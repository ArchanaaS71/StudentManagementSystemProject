package com.sms.admission.dto.request;

import jakarta.validation.constraints.*;

public class ScholarshipAdmissionCreateRequest extends CreateAdmissionRequest {

    @NotBlank(message = "Scholarship reason is required")
    private String scholarshipReason;

    @NotNull(message = "Marks obtained is required")
    @Min(value = 0)
    @Max(value = 100)
    private Integer marksObtained;

	public String getScholarshipReason() {
		return scholarshipReason;
	}

	public void setScholarshipReason(String scholarshipReason) {
		this.scholarshipReason = scholarshipReason;
	}

	public Integer getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Integer marksObtained) {
		this.marksObtained = marksObtained;
	}
    
}
