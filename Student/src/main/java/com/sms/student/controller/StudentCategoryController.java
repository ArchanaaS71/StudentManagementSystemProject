package com.sms.student.controller;

import com.sms.student.dto.request.UpdateStudentCategoryRequest;
import com.sms.student.dto.response.StudentResponse;
import com.sms.student.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students/category")
public class StudentCategoryController {

    private final StudentService studentService;

    public StudentCategoryController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping
    public StudentResponse changeStudentCategory(
            @Valid @RequestBody UpdateStudentCategoryRequest request) {

        return studentService.updateStudentCategory(request);
    }
}

