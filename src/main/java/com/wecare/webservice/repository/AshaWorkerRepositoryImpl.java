package com.wecare.webservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wecare.webservice.model.ContainmentzoneModel;
import com.wecare.webservice.model.PatientModel;
import com.wecare.webservice.model.PlaceModel;
import com.wecare.webservice.model.ResponseModel;
import com.wecare.webservice.model.RouteMapModel;
import com.wecare.webservice.model.WardModel;

@Repository
public class AshaWorkerRepositoryImpl implements AshaWorkerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ResponseModel getPatientListByAshaworker(int awid) {
		ResponseModel model = new ResponseModel();
		List<PatientModel> resultModel = new ArrayList<>();
		model.setStatus(false);
		model.setMessage("No patients available");
		try {
			String patientString = "select * from tbl_viraldiseasereport v inner join tbl_viraldiseasereportrslt vdrr on vdrr.vdr_id=v.vdr_id inner join tbl_familymembers fm on fm.member_id=v.member_id inner join tbl_family f on f.family_id=fm.family_id inner join tbl_viraldisease vd on v.vd_id=vd.vd_id where f.ward_id='"
					+ awid + "'";
			resultModel = jdbcTemplate.query(patientString, BeanPropertyRowMapper.newInstance(PatientModel.class));

			model.setStatus(true);
			model.setData(resultModel);
			model.setMessage("Success");
			return model;

		} catch (Exception e) {
			model.setMessage(e.toString());
			return model;

		}

	}

	@Override
	public ResponseModel getWardList() {
		ResponseModel model=new ResponseModel();
		List<WardModel> resultModel=new ArrayList<>();
		model.setStatus(false);
		model.setMessage("No Ward Available");
		try {
			String wardString="select * from tbl_ward";
			resultModel=jdbcTemplate.query(wardString,BeanPropertyRowMapper.newInstance(WardModel.class));
			model.setStatus(true);
			model.setData(resultModel);
			model.setMessage("Sucess");
			return model;
			
			
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
		
	}

	@Override
	public ResponseModel getPlaceByWard(int wid) {
		ResponseModel model=new ResponseModel();
		List<PlaceModel> resultModel=new ArrayList<>();
		model.setStatus(false);
		model.setMessage("No Ward Available");
		try {
			String placeString="select * from tbl_wardplaces where ward_id='"+wid+"'";
			resultModel=jdbcTemplate.query(placeString,BeanPropertyRowMapper.newInstance(PlaceModel.class));
			model.setStatus(true);
			model.setData(resultModel);
			model.setMessage("Sucess");
			return model;
			
			
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
			
		
	}

	@Override
	public ResponseModel getRouteMapByPatient(int pid) {
		ResponseModel model=new ResponseModel();
		List<RouteMapModel> resultModel=new ArrayList<>();
		model.setStatus(false);
		model.setMessage("No Route Available");
		try {
			String placeString="select * from tbl_route r inner join tbl_routemapmaster rmm on rmm.rutempmstr_id=r.rutempmstr_id inner join tbl_wardplaces wp on wp.wp_id=r.wp_id inner join tbl_ward wr on wr.ward_id=wp.ward_id where vdrprsl_id = '"+pid+"'";
			resultModel=jdbcTemplate.query(placeString,BeanPropertyRowMapper.newInstance(RouteMapModel.class));
			model.setStatus(true);
			model.setData(resultModel);
			model.setMessage("Sucess");
			return model;
			
			
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}

	@Override
	public ResponseModel getContainmentZone(String zone) {
		ResponseModel model=new ResponseModel();
		List<ContainmentzoneModel> resultModel=new ArrayList<>();
		model.setStatus(false);
		model.setMessage("No Place Available");
		try {
			String placeString="select * from tbl_containmentzone c inner join tbl_ward w on w.ward_id=c.ward_id  where ribbon_name = '"+zone+"' order by w.ward_no";
			resultModel=jdbcTemplate.query(placeString,BeanPropertyRowMapper.newInstance(ContainmentzoneModel.class));
			model.setStatus(true);
			model.setData(resultModel);
			model.setMessage("Sucess");
			return model;
			
			
			
		}catch(Exception e) {
			model.setMessage(e.toString());
			return model;
		}
	}

	@Override
	public ResponseModel changePasswordAshaWorker(int awid,String newPassword) {
		ResponseModel model=new ResponseModel();
		model.setStatus(false);
		model.setMessage("Update failed");
		try {
			String updatePasswordString="update tbl_ashaworker set aw_password='"+newPassword+"' WHERE aw_id ='"+awid+"'";
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
	public ResponseModel addRouteMapDetails(Map<String, Object> data) {
		System.out.println(data);
		ResponseModel model=new ResponseModel();
		model.setStatus(false);
		model.setMessage("Update failed");
		try {
			String routeMapMasterQuery = "insert into tbl_routemapmaster(vdrprsl_id,created_by,rutempmstr_isactive)values('" + data.get("vdrprsl_id") + "','" + data.get("created_by") + "','1')";
			int result = jdbcTemplate.update(routeMapMasterQuery);
			if(result == 0) {
				return model;
			}
			
			String maxCountQuery ="select Max(rutempmstr_id) as id from tbl_routemapmaster";
			Map<String,Object> maxData = jdbcTemplate.queryForMap(maxCountQuery);
			long rutempmstr_id = (long) maxData.get("id");
			
			String insRouteQuery = "insert into tbl_route(place_name,wp_id,route_date,route_time,aw_id,rutempmstr_id)"
                    + "values('" + data.get("place_name") + "','" + data.get("wp_id") + "','" + data.get("route_date") + "','" + data.get("route_time") + "','" + data.get("aw_id") + "','" + rutempmstr_id + "')";
			
			int insResult = jdbcTemplate.update(insRouteQuery);
			if(insResult == 0) {
				return model;
			}
			model.setStatus(true);
			model.setData("Route map added");
			model.setMessage("Success");
			
			return model;
		}catch(Exception e) {
			System.out.println(e);
			model.setMessage(e.toString());
			return model;
		}
	}
	

}
