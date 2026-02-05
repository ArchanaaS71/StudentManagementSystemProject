package com.sms.attendance.dto.request;

import com.sms.attendance.enums.AttendanceStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class BulkAttendanceRequest {

    @NotEmpty
    private List<Integer> rollNos;

    @NotBlank
    private String subject;

    @NotNull
    private LocalDate date;

    @NotNull
    private AttendanceStatus status;

	public List<Integer> getRollNos() {
		return rollNos;
	}

	public void setRollNos(List<Integer> rollNos) {
		this.rollNos = rollNos;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public AttendanceStatus getStatus() {
		return status;
	}

	public void setStatus(AttendanceStatus status) {
		this.status = status;
	}

    
}
