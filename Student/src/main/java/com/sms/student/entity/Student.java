package com.sms.student.entity;


import java.time.LocalDateTime;

import com.sms.student.enums.AdmissionMode;
import com.sms.student.enums.StudentCategory;
import com.sms.student.enums.StudentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "roll_no")
    private Integer rollno;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String phonenumber;

    @Column(nullable = false)
    private String department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdmissionMode admissionmode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StudentStatus status;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StudentCategory studentcateogry;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public Integer getRollno() {
		return rollno;
	}

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public AdmissionMode getAdmissionmode() {
		return admissionmode;
	}

	public void setAdmissionmode(AdmissionMode admissionmode) {
		this.admissionmode = admissionmode;
	}

	public StudentStatus getStatus() {
		return status;
	}

	public void setStatus(StudentStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Student() {
		super();
	}

	public Student(Integer rollno, String name, String mail, String phonenumber, String department,
			AdmissionMode admissionmode, StudentStatus status, StudentCategory studentcateogry, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.mail = mail;
		this.phonenumber = phonenumber;
		this.department = department;
		this.admissionmode = admissionmode;
		this.status = status;
		this.studentcateogry = studentcateogry;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public StudentCategory getStudentcateogry() {
		return studentcateogry;
	}

	public void setStudentcateogry(StudentCategory studentcateogry) {
		this.studentcateogry = studentcateogry;
	}
	

   
}
