package com.sms.admission.service;


import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.admission.client.StudentClient;
import com.sms.admission.dto.request.CounsellingAdmissionCreateRequest;
import com.sms.admission.dto.request.CreateStudentRequest;
import com.sms.admission.dto.request.ManagementAdmissionCreateRequest;
import com.sms.admission.dto.request.ScholarshipAdmissionCreateRequest;
import com.sms.admission.dto.request.SportsAdmissionCreateRequest;
import com.sms.admission.dto.response.AdmissionResponse;
import com.sms.admission.entity.Admission;
import com.sms.admission.enums.AdmissionStatus;
import com.sms.admission.mapper.AdmissionMapper;
import com.sms.admission.repository.AdmissionRepository;

@Service
@Transactional
public class AdmissionServiceImpl implements AdmissionService {

    private final AdmissionRepository admissionRepository;
    private final StudentClient studentClient;
    public AdmissionServiceImpl(
            AdmissionRepository admissionRepository,
            StudentClient studentClient) {       
        this.admissionRepository = admissionRepository;
        this.studentClient = studentClient;
    }


   

    @Override
    public AdmissionResponse applyCounsellingAdmission(
            CounsellingAdmissionCreateRequest request) {
     
        if (admissionRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
     
        Admission admission = AdmissionMapper.toCounsellingAdmission(request);
        return saveAndRespond(admission);
    }

    @Override
    public AdmissionResponse applyManagementAdmission(
            ManagementAdmissionCreateRequest request) {
    	
    	 if (admissionRepository.existsByEmail(request.getEmail())) {
             throw new IllegalArgumentException("Email already exists");
         }
        Admission admission = AdmissionMapper.toManagementAdmission(request);
        return saveAndRespond(admission);
    }

    @Override
    public AdmissionResponse applyScholarshipAdmission(
            ScholarshipAdmissionCreateRequest request) {
    	 if (admissionRepository.existsByEmail(request.getEmail())) {
             throw new IllegalArgumentException("Email already exists");
         }

        Admission admission = AdmissionMapper.toScholarshipAdmission(request);
        return saveAndRespond(admission);
    }

    @Override
    public AdmissionResponse applySportsAdmission(
            SportsAdmissionCreateRequest request) {
    	 if (admissionRepository.existsByEmail(request.getEmail())) {
             throw new IllegalArgumentException("Email already exists");
         }
        Admission admission = AdmissionMapper.toSportsAdmission(request);
        return saveAndRespond(admission);
    }

    private AdmissionResponse saveAndRespond(Admission admission) {
        Admission saved = admissionRepository.save(admission);
        return AdmissionMapper.toResponse(saved);
    }


    @Override
    public AdmissionResponse getAdmissionById(Long admissionId) {

        Admission admission = admissionRepository.findById(admissionId)
                .orElseThrow(() -> new RuntimeException("Admission not found"));

        return AdmissionMapper.toResponse(admission);
    }

    @Override
    public List<AdmissionResponse> getAdmissionsByDepartment(String department) {

        return admissionRepository.findByDepartmentIgnoreCase(department)
                .stream()
                .map(AdmissionMapper::toResponse)
                .collect(Collectors.toList());
    }


    @Override
    public AdmissionResponse approveAdmission(Long admissionId) {

        Admission admission = getAdmissionEntity(admissionId);
        admission.setStatus(AdmissionStatus.APPROVED);

        return AdmissionMapper.toResponse(admissionRepository.save(admission));
    }

    @Override
    public AdmissionResponse rejectAdmission(Long admissionId) {

        Admission admission = getAdmissionEntity(admissionId);
        admission.setStatus(AdmissionStatus.REJECTED);

        return AdmissionMapper.toResponse(admissionRepository.save(admission));
    }

//    @Override
//    public AdmissionResponse confirmAdmission(Long admissionId) {
//
//        Admission admission = getAdmissionEntity(admissionId);
//
//        if (admission.getStatus() != AdmissionStatus.APPROVED) {
//            throw new RuntimeException("Only approved admissions can be confirmed");
//        }
//
//        admission.setRollNo(generateRollNumber(admission.getDepartment()));
//        admission.setStatus(AdmissionStatus.CONFIRMED);
//
//        return AdmissionMapper.toResponse(admissionRepository.save(admission));
//    }
    @Override
    public AdmissionResponse confirmAdmission(Long admissionId) {

        Admission admission = getAdmissionEntity(admissionId);

        if (admission.getStatus() != AdmissionStatus.APPROVED) {
            throw new RuntimeException("Only approved admissions can be confirmed");
        }

        
        Integer rollNo = generateRollNumber(admission.getDepartment());
        admission.setRollNo(rollNo);
        admission.setStatus(AdmissionStatus.CONFIRMED);

        
        CreateStudentRequest studentRequest = new CreateStudentRequest();
        studentRequest.setRollno(rollNo);
        studentRequest.setName(admission.getName());
        studentRequest.setMail(admission.getEmail());
        studentRequest.setPhonenumber(admission.getPhone());
        studentRequest.setDepartment(admission.getDepartment());
        studentRequest.setAdmissionmode(admission.getAdmissionMode());

        try {
            studentClient.createStudent(studentRequest);
        } catch (Exception ex) {
            throw new RuntimeException(
                "Admission confirmed but student creation failed", ex
            );
        }

        // 3️⃣ Save admission only AFTER student creation
        Admission saved = admissionRepository.save(admission);

        return AdmissionMapper.toResponse(saved);
    }


    

    private Admission getAdmissionEntity(Long admissionId) {
        return admissionRepository.findById(admissionId)
                .orElseThrow(() -> new RuntimeException("Admission not found"));
    }

    private Integer generateRollNumber(String department) {
        int year = Year.now().getValue() % 100;   
        int random = (int) (Math.random() * 900 + 100); 
        return Integer.parseInt(year + "" + random);
    }
}
