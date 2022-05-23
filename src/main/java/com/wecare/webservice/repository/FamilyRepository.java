package com.wecare.webservice.repository;

import java.util.Map;


import com.wecare.webservice.model.FamilyEditModel;
import com.wecare.webservice.model.FamilyRegisterModel;
import com.wecare.webservice.model.ResponseModel;
import com.wecare.webservice.model.VaccinationModel;


public interface FamilyRepository {
	ResponseModel getFamilyDetails();
	ResponseModel diagonosisResultByUser();
	ResponseModel changePasswordUser(String newPassword,int uid);
	ResponseModel getFamilyRoles();
	ResponseModel familyMemberRegister(FamilyRegisterModel model);
	ResponseModel getFamilyMemberDetails(int fid);
	ResponseModel familyEditMember(FamilyEditModel editModel);
	ResponseModel getSymptomsList();
	ResponseModel getPandemicList();
	ResponseModel getVaccineList(int pid);
	ResponseModel addVaccineDetails(VaccinationModel vaccineModel);
	ResponseModel getMemberHealth();
	ResponseModel addMemberHealthDetails(Map<String,Object> model);
}
