package com.wecare.webservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wecare.webservice.model.DiagnosisResultModel;
import com.wecare.webservice.model.FamilyModel;
import com.wecare.webservice.model.ReportDiagnosisModel;
import com.wecare.webservice.model.ResponseModel;

@Repository
public class DoctorRepositoryImpl implements DoctorRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public ResponseModel diagonosisResultByDoctor() {
		List<DiagnosisResultModel> list = new ArrayList<>();
		ResponseModel responseModel = new ResponseModel();
		responseModel.setMessage("Error");
		responseModel.setStatus(false);
		
		try {
			String diagnosisResultQuery = "SELECT * from tbl_viraldiseasereport v  inner join tbl_familymembers fm on fm.member_id=v.member_id";
			list = jdbcTemplate.query(diagnosisResultQuery, BeanPropertyRowMapper.newInstance(DiagnosisResultModel.class));
			System.out.println(list.size() + "rows fetched");
			
			for(DiagnosisResultModel record : list) {
				String symptomsQuery = "select symp_name from tbl_viraldiseasesymptoms v inner join tbl_symptoms s on v.symp_id=s.symp_id where vdr_id='"+record.getVdr_id()+"'";
				List<String>symptoms = new ArrayList<>();
				symptoms =jdbcTemplate.queryForList(symptomsQuery,String.class);
				record.setSymptoms(symptoms);
			}
			
			responseModel.setStatus(true);
			responseModel.setMessage("Success");
			responseModel.setData(list);
			return responseModel;
		} catch (Exception e) {
			System.out.println(e.toString());
			responseModel.setMessage(e.toString());
			return responseModel;
		}
	}


	@Override
	public ResponseModel reportDiagnosisResult(ReportDiagnosisModel model) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setMessage("Error");
		responseModel.setStatus(false);
		
		try {
			String reportDiagnosis = "insert into tbl_viraldiseasereportrslt(vdr_id,vdrprsl_status,vdrprsl_fdate,vdrprsl_tdate,vdrprsl_duration)values('"+model.getDid()+"','1','"+model.getFdate()+"','"+model.getTdate()+"','"+model.getCount()+"')";
			int result = jdbcTemplate.update(reportDiagnosis); 
			responseModel.setStatus(true);
			responseModel.setMessage("Success");
			responseModel.setData(result);
			return responseModel;
		} catch (Exception e) {
			System.out.println(e.toString());
			responseModel.setMessage(e.toString());
			return responseModel;
		}
	}


}
