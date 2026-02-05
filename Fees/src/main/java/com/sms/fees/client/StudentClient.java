package com.sms.fees.client;

import com.sms.fees.client.dto.StudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service", url = "http://localhost:8081")
public interface StudentClient {

    @GetMapping("/students/roll/{rollNo}")
    StudentResponse getStudentByRoll(@PathVariable Integer rollNo);
}
