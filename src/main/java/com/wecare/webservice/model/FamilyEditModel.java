package com.wecare.webservice.model;

public class FamilyEditModel {
	int member_id;

	String member_name;
	String member_contact;
	String member_email;
	String member_jobstatus;
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_contact() {
		return member_contact;
	}
	public void setMember_contact(String member_contact) {
		this.member_contact = member_contact;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_jobstatus() {
		return member_jobstatus;
	}
	public void setMember_jobstatus(String member_jobstatus) {
		this.member_jobstatus = member_jobstatus;
	}

}
