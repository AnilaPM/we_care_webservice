package com.wecare.webservice.model;

public class PatientModel {
	int vdr_id;
	int rutempmstr_id;
	String member_name;
	String vdr_date;
	String vd_name;
	
	
	
	public int getRutempmstr_id() {
		return rutempmstr_id;
	}
	public void setRutempmstr_id(int rutempmstr_id) {
		this.rutempmstr_id = rutempmstr_id;
	}
	public int getVdr_id() {
		return vdr_id;
	}
	public void setVdr_id(int vdr_id) {
		this.vdr_id = vdr_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getVdr_date() {
		return vdr_date;
	}
	public void setVdr_date(String vdr_date) {
		this.vdr_date = vdr_date;
	}
	public String getVd_name() {
		return vd_name;
	}
	public void setVd_name(String vd_name) {
		this.vd_name = vd_name;
	}

}
