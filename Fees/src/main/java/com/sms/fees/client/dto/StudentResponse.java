package com.sms.fees.client.dto;

import com.sms.fees.enums.StudentCategory;

public class StudentResponse {

    private Integer rollno;
    private StudentCategory studentCategory;
	public Integer getRollno() {
		return rollno;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public StudentCategory getStudentCategory() {
		return studentCategory;
	}
	public void setStudentCategory(StudentCategory studentCategory) {
		this.studentCategory = studentCategory;
	}

    
}
