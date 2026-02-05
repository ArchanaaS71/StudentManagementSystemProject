package com.sms.fees.dto.response;

import com.sms.fees.enums.FeeType;
import com.sms.fees.enums.PaymentStatus;

import java.time.LocalDateTime;

public class FeesResponse {

    private Long id;
    private Integer rollNo;
    private FeeType feeType;
    private Integer amount;
    private Integer semester;
    private PaymentStatus status;
    private LocalDateTime paidAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getSemester() {
		return semester;
	}
	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	public LocalDateTime getPaidAt() {
		return paidAt;
	}
	public void setPaidAt(LocalDateTime paidAt) {
		this.paidAt = paidAt;
	}

   
}
