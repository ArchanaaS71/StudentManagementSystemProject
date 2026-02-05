package com.sms.student.service;



import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sms.student.dto.request.CreateStudentRequest;
import com.sms.student.dto.request.UpdateStudentCategoryRequest;
import com.sms.student.dto.response.StudentResponse;
import com.sms.student.entity.Student;
import com.sms.student.mapper.StudentMapper;
import com.sms.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<StudentResponse> addStudent(CreateStudentRequest request) {

        Student student = StudentMapper.toEntity(request);
        Student saved = studentRepository.save(student);

        return ResponseEntity.ok(StudentMapper.toResponse(saved));
    }

    @Override
    public ResponseEntity<StudentResponse> displayStudentByRoll(Integer rollno) {

        Student student = studentRepository.findById(rollno)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return ResponseEntity.ok(StudentMapper.toResponse(student));
    }

    @Override
    public ResponseEntity<List<StudentResponse>> getStudentsByDepartment(String department) {

        List<StudentResponse> responses =
                studentRepository.findByDepartmentIgnoreCase(department)
                        .stream()
                        .map(StudentMapper::toResponse)
                        .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }
    @Override
    public StudentResponse updateStudentCategory(UpdateStudentCategoryRequest request) {

        Student student = studentRepository.findById(request.getRollno())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (student.getStudentcateogry() == request.getNewCategory()) {
            throw new RuntimeException("Student is already in the selected category");
        }

     

        student.setStudentcateogry(request.getNewCategory());
        student.setUpdatedAt(LocalDateTime.now());

        Student updated = studentRepository.save(student);
        return StudentMapper.toResponse(updated);
    }

}
