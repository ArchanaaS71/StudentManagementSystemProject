package com.sms.student.mapper;



import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.sms.student.dto.request.CreateStudentRequest;
import com.sms.student.dto.response.StudentResponse;
import com.sms.student.entity.Student;
import com.sms.student.enums.StudentStatus;
@Component
public class StudentMapper {

    private StudentMapper() {}

    public static Student toEntity(CreateStudentRequest request) {

        Student student = new Student();
        student.setRollno(request.getRollno());
        student.setName(request.getName());
        student.setMail(request.getMail());
        student.setPhonenumber(request.getPhonenumber());
        student.setDepartment(request.getDepartment());
        student.setAdmissionmode(request.getAdmissionmode());
        student.setStudentcateogry(request.getStudentcategory()); 
        student.setStatus(StudentStatus.ACTIVE);
        student.setCreatedAt(LocalDateTime.now());

        return student;
    }


    public static StudentResponse toResponse(Student student) {

        StudentResponse response = new StudentResponse();
        response.setRollno(student.getRollno());
        response.setName(student.getName());
        response.setMail(student.getMail());
        response.setPhonenumber(student.getPhonenumber());
        response.setDepartment(student.getDepartment());
        response.setAdmissionmode(student.getAdmissionmode());
        response.setStudentcategory(student.getStudentcateogry());
        response.setStatus(student.getStatus());
        response.setCreatedAt(student.getCreatedAt());

        return response;
    }
}
