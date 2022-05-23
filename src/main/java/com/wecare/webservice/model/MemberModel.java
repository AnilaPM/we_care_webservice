package com.wecare.webservice.model;

public class MemberModel {
	
int wm_id;
public int getWm_id() {
	return wm_id;
}
public void setWm_id(int wm_id) {
	this.wm_id = wm_id;
}
public String getWm_name() {
	return wm_name;
}
public void setWm_name(String wm_name) {
	this.wm_name = wm_name;
}
public int getWm_isactive() {
	return wm_isactive;
}
public void setWm_isactive(int wm_isactive) {
	this.wm_isactive = wm_isactive;
}
String wm_name;
int wm_isactive;

}