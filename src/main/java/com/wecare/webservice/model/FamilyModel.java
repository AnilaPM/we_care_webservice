package com.wecare.webservice.model;

public class FamilyModel {
int family_id;
String family_uname;
String family_doj;
int family_isactive;
int family_vstatus;


public int getFamily_id() {
	return family_id;
}
public void setFamily_id(int family_id) {
	this.family_id = family_id;
}

public String getFamily_uname() {
	return family_uname;
}
public void setFamily_uname(String family_uname) {
	this.family_uname = family_uname;
}

public String getFamily_doj() {
	return family_doj;
}
public void setFamily_doj(String family_doj) {
	this.family_doj = family_doj;
}
public int getFamily_isactive() {
	return family_isactive;
}
public void setFamily_isactive(int family_isactive) {
	this.family_isactive = family_isactive;
}
public int getFamily_vstatus() {
	return family_vstatus;
}
public void setFamily_vstatus(int family_vstatus) {
	this.family_vstatus = family_vstatus;
}
}