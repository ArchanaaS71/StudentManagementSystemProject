package com.sms.admission.dto.request;

import jakarta.validation.constraints.*;

public class CounsellingAdmissionCreateRequest extends CreateAdmissionRequest {

    @NotNull(message = "Cutoff marks are required")
    @Min(value = 0)
    @Max(value = 200)
    private Integer cutoffMarks;

	public Integer getCutoffMarks() {
		return cutoffMarks;
	}

	public void setCutoffMarks(Integer cutoffMarks) {
		this.cutoffMarks = cutoffMarks;
	}
    
}

