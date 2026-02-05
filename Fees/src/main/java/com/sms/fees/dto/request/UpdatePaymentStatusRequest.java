package com.sms.fees.dto.request;

import com.sms.fees.enums.PaymentStatus;

import jakarta.validation.constraints.NotNull;

public class UpdatePaymentStatusRequest {

    @NotNull
    private Long feeId;

    @NotNull
    private PaymentStatus status;

	public Long getFeeId() {
		return feeId;
	}

	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
    
    
}
