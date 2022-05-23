package com.wecare.webservice.repository;

import java.util.List;

import com.wecare.webservice.model.FamilyModel;
import com.wecare.webservice.model.ResponseModel;

public interface LoginRepository {
	
	ResponseModel checkLogin(String username,String password);
}