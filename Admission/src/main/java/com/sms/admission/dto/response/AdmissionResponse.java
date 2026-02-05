package com.sms.admission.dto.response;

import java.time.LocalDateTime;

import com.sms.admission.enums.AdmissionMode;
import com.sms.admission.enums.AdmissionStatus;

public class AdmissionResponse {
	    private Long admissionId;
	    private Integer rollNo;

	    private String name;
	    private String department;

	    private AdmissionMode admissionMode;
	    private AdmissionStatus status;

	    private LocalDateTime createdAt;

		public Long getAdmissionId() {
			return admissionId;
		}

		public void setAdmissionId(Long admissionId) {
			this.admissionId = admissionId;
		}

		public Integer getRollNo() {
			return rollNo;
		}

		public void setRollNo(Integer rollNo) {
			this.rollNo = rollNo;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public AdmissionMode getAdmissionMode() {
			return admissionMode;
		}

		public void setAdmissionMode(AdmissionMode admissionMode) {
			this.admissionMode = admissionMode;
		}

		public AdmissionStatus getStatus() {
			return status;
		}

		public void setStatus(AdmissionStatus status) {
			this.status = status;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
	    
	    

}
