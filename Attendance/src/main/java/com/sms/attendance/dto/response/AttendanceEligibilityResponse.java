package com.sms.attendance.dto.response;

public class AttendanceEligibilityResponse {

	   private Integer rollNo;
	    private String subject;
	    private Double attendancePercentage;
	    private Boolean eligible;
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
		public Double getAttendancePercentage() {
			return attendancePercentage;
		}
		public void setAttendancePercentage(Double attendancePercentage) {
			this.attendancePercentage = attendancePercentage;
		}
		public Boolean getEligible() {
			return eligible;
		}
		public void setEligible(Boolean eligible) {
			this.eligible = eligible;
		}
	    
}
