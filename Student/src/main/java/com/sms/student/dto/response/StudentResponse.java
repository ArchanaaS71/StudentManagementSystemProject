package com.sms.student.dto.response;

import java.time.LocalDateTime;

import com.sms.student.enums.AdmissionMode;
import com.sms.student.enums.StudentCategory;
import com.sms.student.enums.StudentStatus;

public class StudentResponse {

    private Integer rollno;
    private String name;
    private String mail;
    private String phonenumber;
    private String department;
    private AdmissionMode admissionmode;
    private StudentStatus status;
    private LocalDateTime createdAt;
    private StudentCategory studentcategory;
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
	public StudentCategory getStudentcategory() {
		return studentcategory;
	}
	public void setStudentcategory(StudentCategory studentcategory) {
		this.studentcategory = studentcategory;
	}
	

    
}
