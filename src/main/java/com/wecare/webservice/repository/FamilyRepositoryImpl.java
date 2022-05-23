package com.wecare.webservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wecare.webservice.model.DiagnosisResultModel;
import com.wecare.webservice.model.FamilyEditModel;
import com.wecare.webservice.model.FamilyMemberModel;
import com.wecare.webservice.model.FamilyModel;
import com.wecare.webservice.model.FamilyRegisterModel;
import com.wecare.webservice.model.FamilyRolesModel;
import com.wecare.webservice.model.ResponseModel;
import com.wecare.webservice.model.VaccinationModel;

@Repository
public class FamilyRepositoryImpl implements FamilyRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ResponseModel getFamilyDetails() {
		// TODO Auto-generated method stub
		List<FamilyModel> list = new ArrayList<>();
		ResponseModel responseModel = new ResponseModel();
		responseModel.setMessage("Error");
		responseModel.setStatus(false);
		
		try {
			list = jdbcTemplate.query("SELECT * FROM tbl_family", BeanPropertyRowMapper.newInstance(FamilyModel.class));
			System.out.println(list.size() + "rows fetched");
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
	public ResponseModel diagonosisResultByUser() {
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
	public ResponseModel changePasswordUser(String newPassword,int uid) {
		ResponseModel model=new ResponseModel();
		model.setStatus(false);
		model.setMessage("Update failed");
		try {
			String updatePasswordString="update tbl_family set family_password='"+newPassword+"' where family_id='"+uid+"'";
			int result=jdbcTemplate.update(updatePasswordString);
			if(result==0) {
				return model;
			}
			model.setStatus(true);
			model.setData(result);
			model.setMessage("Sucess");
			return model;	
			
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}

	@Override
	public ResponseModel getFamilyRoles() {
		List<FamilyRolesModel>familyRoles = new ArrayList<>();
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("No record found");
		try {
			String getFamilyQuery = "select * from tbl_familyrole";
			familyRoles = jdbcTemplate.query(getFamilyQuery, BeanPropertyRowMapper.newInstance(FamilyRolesModel.class));
			model.setData(familyRoles);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
		
		
	}

	@Override
	public ResponseModel familyMemberRegister(FamilyRegisterModel regModel) {
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("Error");
		try {
			String getFamilyQuery = "insert into tbl_familymembers(member_name,member_photo,member_gender,member_contact,member_email,member_dob,member_adhaarno,fr_id,family_id,member_jobstatus)"
	                + "values('"+regModel.getMember_name()+"','NA','"+regModel.getMember_gender()+"','"+regModel.getMember_contact()+"','"+regModel.getMember_email()+"','"+regModel.getMember_dob()+"','"+regModel.getMember_adhaarno()+"','"+regModel.getFr_id()+"','"+regModel.getFamily_id()+"','"+regModel.getMember_jobstatus()+"')";
			int result = jdbcTemplate.update(getFamilyQuery);
			model.setData(result);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}

	@Override
	public ResponseModel getFamilyMemberDetails(int fid) {
		List<FamilyMemberModel>familyMembers = new ArrayList<>();
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("No record found");
		try {
			String getFamilyQuery = "select * from tbl_familymembers fm inner join tbl_familyrole fo on fm.fr_id=fo.fr_id inner join tbl_family f on f.family_id=fm.family_id where fm.family_id='"+fid+"'";
			familyMembers = jdbcTemplate.query(getFamilyQuery, BeanPropertyRowMapper.newInstance(FamilyMemberModel.class));
			model.setData(familyMembers);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}

	@Override
	public ResponseModel familyEditMember(FamilyEditModel editModel) {
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("Error");
		try {
			String getFamilyQuery = "update tbl_familymembers set member_name = '"+editModel.getMember_name()+"'"
                    + ",member_contact='"+editModel.getMember_contact()+"'"
                    + ",member_jobstatus='"+editModel.getMember_jobstatus()+"'"
                    + ",member_email = '"+editModel.getMember_email()+"'"
                    + "where member_id='"+editModel.getMember_id()+"'";
			int result = jdbcTemplate.update(getFamilyQuery);
			model.setData(result);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}

	@Override
	public ResponseModel getSymptomsList() {
		List<Map<String,Object>>symptomsList = new ArrayList<>();
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("No record found");
		try {
			String getSymptomsQuery = "select * from tbl_symptoms";
			symptomsList = jdbcTemplate.queryForList(getSymptomsQuery);
			model.setData(symptomsList);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
		
	}
	@Override
	public ResponseModel getPandemicList() {
		List<Map<String,Object>>pandemicList = new ArrayList<>();
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("No record found");
		try {
			String pandemicQuery = "select * from tbl_pandemic";
			pandemicList = jdbcTemplate.queryForList(pandemicQuery);
			model.setData(pandemicList);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
		
	}

	@Override
	public ResponseModel getVaccineList(int pid) {
		List<Map<String,Object>>vaccineList = new ArrayList<>();
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("No record found");
		try {
			String vaccineQuery = "select * from tbl_vaccine where pandemic_id='"+pid+"'";
			vaccineList = jdbcTemplate.queryForList(vaccineQuery);
			model.setData(vaccineList);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}

	@Override
	public ResponseModel addVaccineDetails(VaccinationModel vaccineModel) {
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("Error");
		try {
			String addVaccineQuery = "insert into tbl_vaccinemember(pandemic_id,vaccine_id,ward_id,member_id,vaccine_dose)"
                    + "values('" + vaccineModel.getPandemic_id() + "','" + vaccineModel.getVaccine_id() + "','" + vaccineModel.getWard_id() + "','" + vaccineModel.getMember_id() + "','" + vaccineModel.getVaccineDose() + "')";
			int result = jdbcTemplate.update(addVaccineQuery);
			model.setData(result);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}
	
	@Override
	public ResponseModel getMemberHealth(){
		List<Map<String,Object>>healthList = new ArrayList<>();
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("No record found");
		try {
			String healthQuery = "select * from tbl_mainhealthissues";
			healthList = jdbcTemplate.queryForList(healthQuery);
			model.setData(healthList);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}

	@Override
	public ResponseModel addMemberHealthDetails(Map<String, Object> healthModel) {
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("Error");
		try {
			
			String healthQuery = "insert into tbl_memberhealth(msi_id,member_id,mh_proof)"
	                + "values('"+healthModel.get("hid").toString()+"','"+healthModel.get("mid")+"','NA')";
			int result = jdbcTemplate.update(healthQuery);
			model.setData(result);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}


}
