package com.wecare.webservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wecare.webservice.model.FamilyEditModel;
import com.wecare.webservice.model.FamilyModel;
import com.wecare.webservice.model.FamilyRegisterModel;
import com.wecare.webservice.model.ReportDiagnosisModel;
import com.wecare.webservice.model.ResponseModel;
import com.wecare.webservice.model.VaccinationModel;
import com.wecare.webservice.repository.AshaWorkerRepository;
import com.wecare.webservice.repository.DoctorRepository;
import com.wecare.webservice.repository.FamilyRepository;
import com.wecare.webservice.repository.LoginRepository;
import com.wecare.webservice.repository.MemberRepository;

@RestController
@RequestMapping("/api")
public class WeCareAPI {
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	FamilyRepository familyRepository;

	@Autowired
	AshaWorkerRepository ashaRepository;

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	MemberRepository memberRepository;

	@GetMapping("/login")

	public ResponseEntity<Object> getLogin(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		try {
			ResponseModel responseModel = loginRepository.checkLogin(username, password);
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Family Module

	@GetMapping("/diagonosisResultByUser")
	public ResponseEntity<Object> diagonosisResultByUser() {
		try {

			ResponseModel responseModel = familyRepository.diagonosisResultByUser();

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAllFamilyDetails")
	public ResponseEntity<Object> getAllFamilyDetails() {
		try {

			ResponseModel responseModel = familyRepository.getFamilyDetails();

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/changePasswordUser")
	public ResponseEntity<Object> changePasswordUser(@RequestParam("newPassword") String newPassword,
			@RequestParam("uid") int uid) {
		try {

			ResponseModel responseModel = familyRepository.changePasswordUser(newPassword, uid);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getFamilyRoles")
	public ResponseEntity<Object> getFamilyRoles() {
		try {

			ResponseModel responseModel = familyRepository.getFamilyRoles();

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/familyMemberRegister")
	public ResponseEntity<Object> familyMemberRegister(@RequestBody FamilyRegisterModel model) {
		try {

			ResponseModel responseModel = familyRepository.familyMemberRegister(model);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getFamilyMemberDetails")
	public ResponseEntity<Object> getFamilyMemberDetails(@RequestParam("fid")int fid) {
		try {

			ResponseModel responseModel = familyRepository.getFamilyMemberDetails(fid);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/familyEditMember")
	public ResponseEntity<Object> familyEditMember(@RequestBody FamilyEditModel model) {
		try {

			ResponseModel responseModel = familyRepository.familyEditMember(model);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getSymptomsList")
	public ResponseEntity<Object> getSymptomsList() {
		try {

			ResponseModel responseModel = familyRepository.getSymptomsList();

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getPandemicList")
	public ResponseEntity<Object> getPandemicList() {
		try {

			ResponseModel responseModel = familyRepository.getPandemicList();

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getVaccineList")
	public ResponseEntity<Object> getVaccineList(@RequestParam("pid")int pid) {
		try {

			ResponseModel responseModel = familyRepository.getVaccineList(pid);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getMemberHealth")
	public ResponseEntity<Object> getMemberHealth() {
		try {

			ResponseModel responseModel = familyRepository.getMemberHealth();

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/addVaccineDetails")
	public ResponseEntity<Object> addVaccineDetails(@RequestBody VaccinationModel model) {
		try {

			ResponseModel responseModel = familyRepository.addVaccineDetails(model);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/addMemberHealthDetails")
	public ResponseEntity<Object> addMemberHealthDetails(@RequestBody Map<String,Object> model) {
		try {

			ResponseModel responseModel = familyRepository.addMemberHealthDetails(model);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

	/// Ashaworker module
	
	
	@PostMapping("/addRouteMapDetails")
	public ResponseEntity<Object> addRouteMapDetails(@RequestBody Map<String,Object> model) {
		try {

			ResponseModel responseModel = ashaRepository.addRouteMapDetails(model);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getPatientListByAshaworker")
	public ResponseEntity<Object> getPatientListByAshaworker(@RequestParam("awid") int awid) {

		try {

			ResponseModel responseModel = ashaRepository.getPatientListByAshaworker(awid);
			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getWardList")
	public ResponseEntity<Object> getWardList() {
		try {

			ResponseModel responseModel = ashaRepository.getWardList();

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getPlaceByWard")
	public ResponseEntity<Object> getPlaceByWard(@RequestParam("wid") int wid) {
		try {

			ResponseModel responseModel = ashaRepository.getPlaceByWard(wid);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getRouteMapByPatient")
	public ResponseEntity<Object> getRouteMapByPatient(@RequestParam("pid") int pid) {
		try {

			ResponseModel responseModel = ashaRepository.getRouteMapByPatient(pid);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getContainmentZone")
	public ResponseEntity<Object> getContainmentZone(@RequestParam("zone") String zone) {
		try {

			ResponseModel responseModel = ashaRepository.getContainmentZone(zone);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/changePasswordAshaWorker")
	public ResponseEntity<Object> changePasswordAshaWorker(@RequestParam("newPassword") String newPassword,
			@RequestParam("awid") int awid) {
		try {

			ResponseModel responseModel = ashaRepository.changePasswordAshaWorker(awid, newPassword);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Doctor module

	@GetMapping("/diagonosisResultByDoctor")
	public ResponseEntity<Object> diagonosisResultByDoctor() {
		try {

			ResponseModel responseModel = doctorRepository.diagonosisResultByDoctor();

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/reportDiagnosisResult")
	public ResponseEntity<Object> reportDiagnosisResult(@RequestBody ReportDiagnosisModel reportDiagnosisModel) {
		try {

			ResponseModel responseModel = doctorRepository.reportDiagnosisResult(reportDiagnosisModel);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//// Ward Member module
	
	@GetMapping("/newFamilyRegRequests")
	public ResponseEntity<Object> newFamilyRegRequests(@RequestParam("wid")int wid){
		try {

			ResponseModel responseModel = memberRepository.newFamilyRegRequests(wid);

			return new ResponseEntity<>(responseModel, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
