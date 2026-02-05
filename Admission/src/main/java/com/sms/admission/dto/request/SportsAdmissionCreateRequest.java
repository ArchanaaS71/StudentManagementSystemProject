package com.sms.admission.dto.request;


import com.sms.admission.enums.SportLevel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SportsAdmissionCreateRequest extends CreateAdmissionRequest {

    @NotBlank(message = "Sport name is required")
    private String sportName;

    @NotNull(message = "Sport level is required")
    private SportLevel sportLevel;

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public SportLevel getSportLevel() {
		return sportLevel;
	}

	public void setSportLevel(SportLevel sportLevel) {
		this.sportLevel = sportLevel;
	}
    
}
