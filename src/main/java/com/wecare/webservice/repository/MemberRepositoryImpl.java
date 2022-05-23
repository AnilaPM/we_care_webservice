package com.wecare.webservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class MemberRepositoryImpl implements MemberRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ResponseModel newFamilyRegRequests(int wid) {
		List<Map<String,Object>>requestList = new ArrayList<>();
		ResponseModel model = new ResponseModel();
		model.setStatus(false);
		model.setMessage("No record found");
		try {
			String requestQuery = "select * from tbl_family f inner join tbl_wardplaces p on p.wp_id=f.wp_id inner join tbl_ward w on f.ward_id=w.ward_id where f.ward_id='"+wid+"' and family_vstatus='0'";
			requestList = jdbcTemplate.queryForList(requestQuery);
			model.setData(requestList);
			model.setStatus(true);
			model.setMessage("Success");
			return model;
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}


}