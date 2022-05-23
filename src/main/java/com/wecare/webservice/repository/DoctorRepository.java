package com.wecare.webservice.repository;

import com.wecare.webservice.model.ReportDiagnosisModel;
import com.wecare.webservice.model.ResponseModel;

public interface DoctorRepository {

	public ResponseModel diagonosisResultByDoctor();
	public ResponseModel reportDiagnosisResult(ReportDiagnosisModel model);

	
}