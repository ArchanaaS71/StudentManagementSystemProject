package com.sms.admission.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.admission.dto.request.CounsellingAdmissionCreateRequest;
import com.sms.admission.dto.request.ManagementAdmissionCreateRequest;
import com.sms.admission.dto.request.ScholarshipAdmissionCreateRequest;
import com.sms.admission.dto.request.SportsAdmissionCreateRequest;
import com.sms.admission.dto.response.AdmissionResponse;
import com.sms.admission.service.AdmissionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {

    private final AdmissionService admissionService;

    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

  
    @PostMapping("/counselling")
    public ResponseEntity<AdmissionResponse> applyCounsellingAdmission(
            @Valid @RequestBody CounsellingAdmissionCreateRequest request) {

        AdmissionResponse response =
                admissionService.applyCounsellingAdmission(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/management")
    public ResponseEntity<AdmissionResponse> applyManagementAdmission(
            @Valid @RequestBody ManagementAdmissionCreateRequest request) {

        AdmissionResponse response =
                admissionService.applyManagementAdmission(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/scholarship")
    public ResponseEntity<AdmissionResponse> applyScholarshipAdmission(
            @Valid @RequestBody ScholarshipAdmissionCreateRequest request) {

        AdmissionResponse response =
                admissionService.applyScholarshipAdmission(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/sports")
    public ResponseEntity<AdmissionResponse> applySportsAdmission(
            @Valid @RequestBody SportsAdmissionCreateRequest request) {

        AdmissionResponse response =
                admissionService.applySportsAdmission(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

   

    @GetMapping("/{admissionId}")
    public ResponseEntity<AdmissionResponse> getAdmissionById(
            @PathVariable Long admissionId) {

        AdmissionResponse response =
                admissionService.getAdmissionById(admissionId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<AdmissionResponse>> getAdmissionsByDepartment(
            @PathVariable String department) {

        List<AdmissionResponse> responses =
                admissionService.getAdmissionsByDepartment(department);

        return ResponseEntity.ok(responses);
    }

   

    @PutMapping("/{admissionId}/approve")
    public ResponseEntity<AdmissionResponse> approveAdmission(
            @PathVariable Long admissionId) {

        AdmissionResponse response =
                admissionService.approveAdmission(admissionId);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{admissionId}/reject")
    public ResponseEntity<AdmissionResponse> rejectAdmission(
            @PathVariable Long admissionId) {

        AdmissionResponse response =
                admissionService.rejectAdmission(admissionId);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{admissionId}/confirm")
    public ResponseEntity<AdmissionResponse> confirmAdmission(
            @PathVariable Long admissionId) {

        AdmissionResponse response =
                admissionService.confirmAdmission(admissionId);

        return ResponseEntity.ok(response);
    }
}

