package com.sms.student.dto.request;



import com.sms.student.enums.AdmissionMode;
import com.sms.student.enums.StudentCategory;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CreateStudentRequest {

    @NotNull(message = "Roll number is required")
    private Integer rollno;

    @NotBlank(message = "Student name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String mail;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
    private String phonenumber;

    @NotBlank(message = "Department is required")
    private String department;

    @NotNull(message = "Admission mode is required")
    private AdmissionMode admissionmode;
    
    @NotNull(message = "Admission mode is required")
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

	public StudentCategory getStudentcategory() {
		return studentcategory;
	}

	public void setStudentcategory(StudentCategory studentcategory) {
		this.studentcategory = studentcategory;
	}

	
	
    
}
