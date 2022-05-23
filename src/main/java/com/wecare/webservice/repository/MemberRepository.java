package com.wecare.webservice.repository;

import com.wecare.webservice.model.ResponseModel;

public interface MemberRepository {
	
	ResponseModel newFamilyRegRequests(int wid);
}