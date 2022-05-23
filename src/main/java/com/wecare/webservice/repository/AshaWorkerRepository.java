package com.wecare.webservice.repository;

import java.util.Map;

import com.wecare.webservice.model.ResponseModel;

public interface AshaWorkerRepository {

	public ResponseModel getPatientListByAshaworker(int awid);
	public ResponseModel getWardList();
	public ResponseModel getPlaceByWard(int wid);
	public ResponseModel getRouteMapByPatient(int pid);
	public ResponseModel getContainmentZone(String zone);
	public ResponseModel changePasswordAshaWorker(int awid,String newPassword);
	public ResponseModel addRouteMapDetails(Map<String, Object> model);
	
}