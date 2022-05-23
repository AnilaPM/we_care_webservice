package com.wecare.webservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wecare.webservice.model.AshaWorkerModel;
import com.wecare.webservice.model.DoctorModel;
import com.wecare.webservice.model.FamilyModel;
import com.wecare.webservice.model.LoginUserModel;
import com.wecare.webservice.model.MemberModel;
import com.wecare.webservice.model.ResponseModel;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public ResponseModel checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("Invalid login");
		LoginUserModel loginModel = new LoginUserModel();
		String familyString = "SELECT * FROM tbl_family where family_uname='" + username + "' and family_password='"
				+ password + "'";
		String ashaWorkerString = "SELECT * FROM tbl_ashaworker where aw_uname='" + username + "' and aw_password='"
				+ password + "'";
		String doctorString = "SELECT * FROM tbl_doctor where doctor_uname='" + username + "' and doctor_password='"
				+ password + "'";
		String wardMemberString = "SELECT * FROM tbl_wardmember where wm_uname='" + username + "' and wm_password='"
				+ password + "'";
		FamilyModel familyModel = null;
		AshaWorkerModel ashaWorkerModel = null;
		DoctorModel doctorModel = null;
		MemberModel memberModel = null;

		try {
			familyModel = jdbcTemplate.queryForObject(familyString,
					BeanPropertyRowMapper.newInstance(FamilyModel.class));
		} catch (Exception e) {

		}
		System.out.println("p1");
		if (familyModel != null) {
			
			loginModel.setUserID(familyModel.getFamily_id());
			loginModel.setUserName(familyModel.getFamily_uname());
			loginModel.setUserType("Family");

			model.setMessage("Success");
			model.setStatus(true);
			model.setData(loginModel);

			return model;
		} else {
		
			try {
				ashaWorkerModel = jdbcTemplate.queryForObject(ashaWorkerString,
						BeanPropertyRowMapper.newInstance(AshaWorkerModel.class));
			} catch (Exception e) {

			}
			if (ashaWorkerModel != null) {
				
				loginModel.setUserID(ashaWorkerModel.getAw_id());
				loginModel.setUserName(ashaWorkerModel.getAw_name());
				loginModel.setUserType("AshaWorker");

				model.setMessage("Success");
				model.setStatus(true);
				model.setData(loginModel);

				return model;
			} else {
				System.out.println("d1");
				try {
					doctorModel = jdbcTemplate.queryForObject(doctorString,
							BeanPropertyRowMapper.newInstance(DoctorModel.class));
				} catch (Exception e) {

				}
				if (doctorModel != null) {
					loginModel.setUserID(doctorModel.getDoctor_id());
					loginModel.setUserName(doctorModel.getDoctor_name());
					loginModel.setUserType("Doctor");

					model.setMessage("Success");
					model.setStatus(true);
					model.setData(loginModel);

					return model;
				} else {
					try {
						memberModel = jdbcTemplate.queryForObject(wardMemberString,
								BeanPropertyRowMapper.newInstance(MemberModel.class));
					} catch (Exception e) {

					}
					if (memberModel != null) {
						loginModel.setUserID(memberModel.getWm_id());
						loginModel.setUserName(memberModel.getWm_name());
						loginModel.setUserType("WardMember");

						model.setMessage("Success");
						model.setStatus(true);
						model.setData(loginModel);

						return model;
					}
				}
			}

		}

		return model;
	}

}