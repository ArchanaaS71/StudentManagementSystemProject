package com.sms.admission.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sms.admission.dto.request.CreateStudentRequest;
import com.sms.admission.dto.response.StudentResponse;

@FeignClient(
    name = "student-service",
    url = "http://localhost:8081"   
)
public interface StudentClient {

    @PostMapping("/internal/students")
    StudentResponse createStudent(@RequestBody CreateStudentRequest request);
}
