package com.wecare.webservice.model;

public class DoctorModel {
	
int doctor_id;
String doctor_name;
int doctor_isactive;


public int getDoctor_id() {
	return doctor_id;
}
public void setDoctor_id(int doctor_id) {
	this.doctor_id = doctor_id;
}
public String getDoctor_name() {
	return doctor_name;
}
public void setDoctor_name(String doctor_name) {
	this.doctor_name = doctor_name;
}
public int getDoctor_isactive() {
	return doctor_isactive;
}
public void setDoctor_isactive(int doctor_isactive) {
	this.doctor_isactive = doctor_isactive;
}

}