package com.sms.attendance.dto.response;

import com.sms.attendance.enums.AttendanceStatus;
import java.time.LocalDate;

public class AttendanceResponse {

    private Integer rollNo;
    private String subject;
    private LocalDate date;
    private AttendanceStatus status;
	public Integer getRollNo() {
		return rollNo;
	}
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
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
