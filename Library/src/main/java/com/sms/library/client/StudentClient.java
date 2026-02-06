package com.sms.library.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service", url = "http://localhost:8081")
public interface StudentClient {

    @GetMapping("/students/roll/{rollNo}")
    Object getStudentByRoll(@PathVariable Integer rollNo);
}
