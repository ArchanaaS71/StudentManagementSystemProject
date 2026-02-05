package com.sms.admission.mapper;


import java.time.LocalDateTime;

import com.sms.admission.dto.request.CounsellingAdmissionCreateRequest;
import com.sms.admission.dto.request.CreateAdmissionRequest;
import com.sms.admission.dto.request.ManagementAdmissionCreateRequest;
import com.sms.admission.dto.request.ScholarshipAdmissionCreateRequest;
import com.sms.admission.dto.request.SportsAdmissionCreateRequest;
import com.sms.admission.dto.response.AdmissionResponse;
import com.sms.admission.entity.Admission;
import com.sms.admission.entity.CounsellingAdmission;
import com.sms.admission.entity.ManagementAdmission;
import com.sms.admission.entity.ScholarshipAdmission;
import com.sms.admission.entity.SportsAdmission;
import com.sms.admission.enums.AdmissionMode;
import com.sms.admission.enums.AdmissionStatus;

public class AdmissionMapper {

    private AdmissionMapper() {
        // utility class
    }


    public static Admission toCounsellingAdmission(
            CounsellingAdmissionCreateRequest request) {

        Admission admission = buildBaseAdmission(request);
        admission.setAdmissionMode(AdmissionMode.COUNSELLING);
        admission.setStatus(AdmissionStatus.APPLIED);

        CounsellingAdmission counselling = new CounsellingAdmission();
        counselling.setCutoffMarks(request.getCutoffMarks());
        counselling.setAdmission(admission);

        admission.setCounselling(counselling);
        return admission;
    }

    public static Admission toManagementAdmission(
            ManagementAdmissionCreateRequest request) {

        Admission admission = buildBaseAdmission(request);
        admission.setAdmissionMode(AdmissionMode.MANAGEMENT);
        admission.setStatus(AdmissionStatus.APPLIED);

        ManagementAdmission management = new ManagementAdmission();
        management.setReferralName(request.getReferralName());
        management.setReferralContact(request.getReferralContact());
        management.setAdmission(admission);

        admission.setManagement(management);
        return admission;
    }

    public static Admission toScholarshipAdmission(
            ScholarshipAdmissionCreateRequest request) {

        Admission admission = buildBaseAdmission(request);
        admission.setAdmissionMode(AdmissionMode.SCHOLARSHIP);
        admission.setStatus(AdmissionStatus.APPLIED);

        ScholarshipAdmission scholarship = new ScholarshipAdmission();
        scholarship.setScholarshipReason(request.getScholarshipReason());
        scholarship.setMarksObtained(request.getMarksObtained());
        scholarship.setAdmission(admission);

        admission.setScholarship(scholarship);
        return admission;
    }

    public static Admission toSportsAdmission(
            SportsAdmissionCreateRequest request) {

        Admission admission = buildBaseAdmission(request);
        admission.setAdmissionMode(AdmissionMode.SPORTS);
        admission.setStatus(AdmissionStatus.APPLIED);

        SportsAdmission sports = new SportsAdmission();
        sports.setSportName(request.getSportName());
        sports.setSportLevel(request.getSportLevel());
        sports.setAdmission(admission);

        admission.setSports(sports);
        return admission;
    }


    private static Admission buildBaseAdmission(CreateAdmissionRequest request) {

        Admission admission = new Admission();
        admission.setName(request.getName());
        admission.setEmail(request.getEmail());
        admission.setPhone(request.getPhone());
        admission.setAddress(request.getAddress());
        admission.setFatherName(request.getFatherName());
        admission.setMotherName(request.getMotherName());
        admission.setParentPhone(request.getParentPhone());
        admission.setSchool(request.getSchool());
        admission.setTenthPercentage(request.getTenthPercentage());
        admission.setTwelfthPercentage(request.getTwelfthPercentage());       
        admission.setDepartment(request.getDepartment());
        admission.setCreatedAt(LocalDateTime.now());
        admission.setUpdatedAt(LocalDateTime.now());

        return admission;
    }


    public static AdmissionResponse toResponse(Admission admission) {

        AdmissionResponse response = new AdmissionResponse();

        response.setAdmissionId(admission.getId());
        response.setRollNo(admission.getRollNo());
        response.setName(admission.getName());
        response.setDepartment(admission.getDepartment());
        response.setAdmissionMode(admission.getAdmissionMode());
        response.setStatus(admission.getStatus());
        response.setCreatedAt(admission.getCreatedAt());

        return response;
    }
}
