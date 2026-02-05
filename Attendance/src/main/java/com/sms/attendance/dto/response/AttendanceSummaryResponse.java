package com.sms.attendance.dto.response;

public class AttendanceSummaryResponse {

    private Integer rollNo;
    private String subject;
    private Long totalClasses;
    private Long presentCount;
    private Double attendancePercentage;
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
	public Long getTotalClasses() {
		return totalClasses;
	}
	public void setTotalClasses(Long totalClasses) {
		this.totalClasses = totalClasses;
	}
	public Long getPresentCount() {
		return presentCount;
	}
	public void setPresentCount(Long presentCount) {
		this.presentCount = presentCount;
	}
	public Double getAttendancePercentage() {
		return attendancePercentage;
	}
	public void setAttendancePercentage(Double attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}
    
}
