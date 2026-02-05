package com.sms.student.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.student.dto.request.CreateStudentRequest;
import com.sms.student.dto.response.StudentResponse;
import com.sms.student.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/internal/students")
public class StudentInternalController {

    private StudentService studentService;
    public StudentInternalController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(
            @Valid @RequestBody CreateStudentRequest request) {
        return studentService.addStudent(request);
    }
}

