package com.wecare.webservice.model;

import java.util.List;
import java.util.Map;

public class AddDieseaseModel {
int member_id;
String vdd_caption;
String vdr_date;
List<Map<String,Object>>symptoms;
public int getMember_id() {
	return member_id;
}
public void setMember_id(int member_id) {
	this.member_id = member_id;
}
public String getVdd_caption() {
	return vdd_caption;
}
public void setVdd_caption(String vdd_caption) {
	this.vdd_caption = vdd_caption;
}
public String getVdr_date() {
	return vdr_date;
}
public void setVdr_date(String vdr_date) {
	this.vdr_date = vdr_date;
}
public List<Map<String, Object>> getSymptoms() {
	return symptoms;
}
public void setSymptoms(List<Map<String, Object>> symptoms) {
	this.symptoms = symptoms;
}
}
