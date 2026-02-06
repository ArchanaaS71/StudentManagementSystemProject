package com.sms.library.dto.request;

import jakarta.validation.constraints.NotNull;

public class ReturnBookRequest {

    @NotNull
    private Long transactionId;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

    
}
