package com.wecare.webservice.model;

import java.util.List;

public class DiagnosisResultModel {
	int vdr_id;
	int vd_id;
	String vdr_date;
	String member_name;
	String vdd_caption;
	String member_contact;
	List<String>symptoms;
	
	public int getVdr_id() {
		return vdr_id;
	}
	public void setVdr_id(int vdr_id) {
		this.vdr_id = vdr_id;
	}
	public int getVd_id() {
		return vd_id;
	}
	public void setVd_id(int vd_id) {
		this.vd_id = vd_id;
	}
	public String getVdr_date() {
		return vdr_date;
	}
	public void setVdr_date(String vdr_date) {
		this.vdr_date = vdr_date;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getVdd_caption() {
		return vdd_caption;
	}
	public void setVdd_caption(String vdd_caption) {
		this.vdd_caption = vdd_caption;
	}
	public String getMember_contact() {
		return member_contact;
	}
	public void setMember_contact(String member_contact) {
		this.member_contact = member_contact;
	}
	public List<String> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}

}
