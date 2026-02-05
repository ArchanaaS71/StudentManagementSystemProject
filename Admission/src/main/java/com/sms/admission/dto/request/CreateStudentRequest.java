package com.sms.admission.dto.request;

import com.sms.admission.enums.AdmissionMode;

public class CreateStudentRequest {

    private Integer rollno;
    private String name;
    private String mail;
    private String phonenumber;
    private String department;
    private AdmissionMode admissionmode;
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
    
}

