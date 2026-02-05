package com.sms.admission.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ManagementAdmissionCreateRequest extends CreateAdmissionRequest {

    @NotBlank(message = "Referral name is required")
    private String referralName;

    @NotBlank(message = "Referral contact is required")
    private String referralContact;

	public String getReferralName() {
		return referralName;
	}

	public void setReferralName(String referralName) {
		this.referralName = referralName;
	}

	public String getReferralContact() {
		return referralContact;
	}

	public void setReferralContact(String referralContact) {
		this.referralContact = referralContact;
	}
    
}
