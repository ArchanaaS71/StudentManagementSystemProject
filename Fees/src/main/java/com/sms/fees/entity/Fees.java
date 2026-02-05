package com.sms.fees.entity;

import com.sms.fees.enums.FeeType;
import com.sms.fees.enums.PaymentStatus;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fees")
public class Fees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rollNo;

    @Enumerated(EnumType.STRING)
    private FeeType feeType;

    private Integer amount;

    private Integer semester;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDateTime createdAt;
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getPaidAt() {
		return paidAt;
	}
	public void setPaidAt(LocalDateTime paidAt) {
		this.paidAt = paidAt;
	}
	public Fees(Long id, Integer rollNo, FeeType feeType, Integer amount, Integer semester, PaymentStatus status,
			LocalDateTime createdAt, LocalDateTime paidAt) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.feeType = feeType;
		this.amount = amount;
		this.semester = semester;
		this.status = status;
		this.createdAt = createdAt;
		this.paidAt = paidAt;
	}
	public Fees() {
		super();
	}
	

    
}
