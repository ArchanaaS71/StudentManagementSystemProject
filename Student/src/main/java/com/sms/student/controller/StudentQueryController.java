package com.sms.student.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.student.dto.response.StudentResponse;
import com.sms.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentQueryController {

    private StudentService studentService;
    

    public StudentQueryController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/roll/{rollno}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Integer rollno) {
        return studentService.displayStudentByRoll(rollno);
    }

    @GetMapping("/dept/{department}")
    public ResponseEntity<List<StudentResponse>> getByDepartment(
            @PathVariable String department) {
        return studentService.getStudentsByDepartment(department);
    }
}
