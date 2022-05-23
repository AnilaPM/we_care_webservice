package com.wecare.webservice.model;

public class VaccinationModel {

	int pandemic_id;
	int vaccine_id;
	int member_id;
	int ward_id;
	String vaccineDose;
	
	public int getPandemic_id() {
		return pandemic_id;
	}
	public void setPandemic_id(int pandemic_id) {
		this.pandemic_id = pandemic_id;
	}
	public int getVaccine_id() {
		return vaccine_id;
	}
	public void setVaccine_id(int vaccine_id) {
		this.vaccine_id = vaccine_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getVaccineDose() {
		return vaccineDose;
	}
	public void setVaccineDose(String vaccineDose) {
		this.vaccineDose = vaccineDose;
	}
	public int getWard_id() {
		return ward_id;
	}
	public void setWard_id(int ward_id) {
		this.ward_id = ward_id;
	}
	
}
