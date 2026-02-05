package com.sms.student.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByDepartmentIgnoreCase(String department);
}
