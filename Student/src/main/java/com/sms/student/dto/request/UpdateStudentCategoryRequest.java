package com.sms.student.dto.request;

import com.sms.student.enums.StudentCategory;
import jakarta.validation.constraints.NotNull;

public class UpdateStudentCategoryRequest {

    @NotNull
    private Integer rollno;

    @NotNull
    private StudentCategory newCategory;

    
    private String reason;


	public Integer getRollno() {
		return rollno;
	}


	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}


	public StudentCategory getNewCategory() {
		return newCategory;
	}


	public void setNewCategory(StudentCategory newCategory) {
		this.newCategory = newCategory;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
    

   
}
