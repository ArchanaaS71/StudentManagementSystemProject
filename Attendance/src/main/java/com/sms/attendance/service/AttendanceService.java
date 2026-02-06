package com.sms.attendance.service;

import com.sms.attendance.dto.request.BulkAttendanceRequest;
import com.sms.attendance.dto.request.MarkAttendanceRequest;
import com.sms.attendance.dto.response.AttendanceEligibilityResponse;
import com.sms.attendance.dto.response.AttendanceResponse;
import com.sms.attendance.dto.response.AttendanceSummaryResponse;

import java.util.List;

public interface AttendanceService {

    AttendanceResponse markAttendance(MarkAttendanceRequest request);

    List<AttendanceResponse> getAttendanceByRollNo(Integer rollNo);

    List<AttendanceResponse> getAttendanceBySubject(Integer rollNo, String subject);

    AttendanceSummaryResponse getAttendanceSummary(Integer rollNo, String subject);
    
    List<AttendanceResponse> markBulkAttendance(BulkAttendanceRequest request);

    AttendanceEligibilityResponse checkEligibility(Integer rollNo,String subject);

}

