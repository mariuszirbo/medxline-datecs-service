package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	private String status;
	private List<ResultLogCasa> data;

	public Response() {

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ResultLogCasa> getData() {
		return data;
	}

	public void setData(List<ResultLogCasa> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", data=" + data + "]";
	}

}
