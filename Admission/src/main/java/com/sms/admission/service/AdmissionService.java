package com.sms.admission.service;

import java.util.List;

import com.sms.admission.dto.request.CounsellingAdmissionCreateRequest;
import com.sms.admission.dto.request.ManagementAdmissionCreateRequest;
import com.sms.admission.dto.request.ScholarshipAdmissionCreateRequest;
import com.sms.admission.dto.request.SportsAdmissionCreateRequest;
import com.sms.admission.dto.response.AdmissionResponse;

import jakarta.validation.Valid;

public interface AdmissionService {

	AdmissionResponse applyCounsellingAdmission(@Valid CounsellingAdmissionCreateRequest request);

	AdmissionResponse applyManagementAdmission(@Valid ManagementAdmissionCreateRequest request);

	AdmissionResponse applyScholarshipAdmission(@Valid ScholarshipAdmissionCreateRequest request);

	AdmissionResponse applySportsAdmission(@Valid SportsAdmissionCreateRequest request);

	AdmissionResponse getAdmissionById(Long admissionId);

	List<AdmissionResponse> getAdmissionsByDepartment(String department);

	AdmissionResponse approveAdmission(Long admissionId);

	AdmissionResponse rejectAdmission(Long admissionId);

	AdmissionResponse confirmAdmission(Long admissionId);

}
