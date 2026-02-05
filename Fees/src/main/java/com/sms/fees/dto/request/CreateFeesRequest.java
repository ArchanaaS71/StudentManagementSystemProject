package com.sms.fees.dto.request;


import com.sms.fees.enums.FeeType;
import com.sms.fees.enums.StudentCategory;

import jakarta.validation.constraints.NotNull;

public class CreateFeesRequest {

    @NotNull
    private Integer rollNo;

    @NotNull
    private FeeType feeType;

    private Integer semester;

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public FeeType getFeeType() {
		return feeType;
	}

	public void setFeeType(FeeType feeType) {
		this.feeType = feeType;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

    
}
