package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultLogCasa {
	private String id;
	private String data_log;
	private String comanda_casa;
	private String casa_id;
	private String executat;
	private String programare_id;
	private String consultatie_id;
	private String factura_id;
	private String valoare_totala;
	private String emisa_de;
	private String tip_plata;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData_log() {
		return data_log;
	}

	public void setData_log(String data_log) {
		this.data_log = data_log;
	}

	public String getComanda_casa() {
		return comanda_casa;
	}

	public void setComanda_casa(String comanda_casa) {
		this.comanda_casa = comanda_casa;
	}

	public String getCasa_id() {
		return casa_id;
	}

	public void setCasa_id(String casa_id) {
		this.casa_id = casa_id;
	}

	public String getExecutat() {
		return executat;
	}

	public void setExecutat(String executat) {
		this.executat = executat;
	}

	public String getProgramare_id() {
		return programare_id;
	}

	public void setProgramare_id(String programare_id) {
		this.programare_id = programare_id;
	}

	public String getConsultatie_id() {
		return consultatie_id;
	}

	public void setConsultatie_id(String consultatie_id) {
		this.consultatie_id = consultatie_id;
	}

	public String getFactura_id() {
		return factura_id;
	}

	public void setFactura_id(String factura_id) {
		this.factura_id = factura_id;
	}

	public String getValoare_totala() {
		return valoare_totala;
	}

	public void setValoare_totala(String valoare_totala) {
		this.valoare_totala = valoare_totala;
	}

	public String getEmisa_de() {
		return emisa_de;
	}

	public void setEmisa_de(String emisa_de) {
		this.emisa_de = emisa_de;
	}

	public String getTip_plata() {
		return tip_plata;
	}

	public void setTip_plata(String tip_plata) {
		this.tip_plata = tip_plata;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", data_log=" + data_log + ", comanda_casa=" + comanda_casa + ", casa_id=" + casa_id
				+ ", executat=" + executat + ", programare_id=" + programare_id + ", consultatie_id=" + consultatie_id
				+ ", factura_id=" + factura_id + ", valoare_totala=" + valoare_totala + ", emisa_de=" + emisa_de
				+ ", tip_plata=" + tip_plata + "]";
	}

	public ResultLogCasa() {
	}

}
