package com.sms.student.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sms.student.dto.request.CreateStudentRequest;
import com.sms.student.dto.request.UpdateStudentCategoryRequest;
import com.sms.student.dto.response.StudentResponse;

public interface StudentService {

    ResponseEntity<StudentResponse> addStudent(CreateStudentRequest request);

    ResponseEntity<StudentResponse> displayStudentByRoll(Integer rollno);

    ResponseEntity<List<StudentResponse>> getStudentsByDepartment(String department);

    StudentResponse updateStudentCategory(UpdateStudentCategoryRequest request);
}


