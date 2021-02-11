package com.example.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MeridianKasaApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		System.out.println("Init test: OK!");

		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				try {

					// STERGERE CONTINUT FISIER
					BufferedWriter mainWriter = new BufferedWriter(new FileWriter("bon.inp"));
					mainWriter.write("");

					// REST API CALL

					// HEADER
					HttpHeaders headers = new HttpHeaders();
					headers.set("x-api-key", "7e6620f1-199e-422c-86ea-1466a1d68899");
					headers.setContentType(MediaType.APPLICATION_JSON);

					// REQUEST
					HttpEntity<String> request = new HttpEntity<String>(headers);

					RestTemplate restTemplate = new RestTemplate();

					ResponseEntity<Response> response = restTemplate.exchange(
							"https://24285bebe387.ngrok.io/log-scriere-casa", HttpMethod.GET, request, Response.class);

					System.out.println("==== RESTful API Response using Spring RESTTemplate START =======");
					System.out.println(response.getBody().toString());
					System.out.println("==== RESTful API Response using Spring RESTTemplate END =======");

					// WRITE IN FILE TYPE .INP

					List<ResultLogCasa> resultList = response.getBody().getData();
					List<String> postList = new ArrayList<String>();

					resultList.stream().forEach(result -> {
						try {
							mainWriter.write(result.getComanda_casa());
							mainWriter.newLine();
							postList.add(result.getId());
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
					mainWriter.close();

					// MODIFICARE STATUS _EXECUTAT
					if (!postList.isEmpty()) {
						String body = Arrays.toString(postList.toArray()).replace("[", "").replace("]", "");
						System.out.println(body);

						headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
						HttpEntity<String> postRequest = new HttpEntity<String>("id=" + body, headers);
						ResponseEntity<Response> postResponse = restTemplate
								.postForEntity("https://24285bebe387.ngrok.io/log-update", postRequest, Response.class);

						if (postResponse.getStatusCode().equals(HttpStatus.OK)) {
							System.out.println("Update on ids with Success!");
						}

						System.out.println("==== RESTful API POST START =======");
						System.out.println(response.getBody().toString());
						System.out.println("==== RESTful API POST END =======");

						System.out.println("Successfully wrote to the file!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}, 0, 10, TimeUnit.SECONDS);

	}

}
