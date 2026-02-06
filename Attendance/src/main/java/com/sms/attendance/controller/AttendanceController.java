package com.sms.attendance.controller;

import com.sms.attendance.dto.request.BulkAttendanceRequest;
import com.sms.attendance.dto.request.MarkAttendanceRequest;
import com.sms.attendance.dto.response.AttendanceEligibilityResponse;
import com.sms.attendance.dto.response.AttendanceResponse;
import com.sms.attendance.dto.response.AttendanceSummaryResponse;
import com.sms.attendance.service.AttendanceService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping
    public AttendanceResponse markAttendance(
            @Valid @RequestBody MarkAttendanceRequest request) {
        return attendanceService.markAttendance(request);
    }
    
    @PostMapping("/bulk")
    public List<AttendanceResponse> markBulkAttendance(
            @Valid @RequestBody BulkAttendanceRequest request) {
        return attendanceService.markBulkAttendance(request);
    }


    @GetMapping("/roll/{rollNo}")
    public List<AttendanceResponse> getByRoll(
            @PathVariable Integer rollNo) {
        return attendanceService.getAttendanceByRollNo(rollNo);
    }

    @GetMapping("/roll/{rollNo}/subject/{subject}")
    public List<AttendanceResponse> getBySubject(
            @PathVariable Integer rollNo,
            @PathVariable String subject) {
        return attendanceService.getAttendanceBySubject(rollNo, subject);
    }

    @GetMapping("/roll/{rollNo}/subject/{subject}/summary")
    public AttendanceSummaryResponse getSummary(
            @PathVariable Integer rollNo,
            @PathVariable String subject) {
        return attendanceService.getAttendanceSummary(rollNo, subject);
    }
    @GetMapping("/roll/{rollNo}/subject/{subject}/eligibility")
    public AttendanceEligibilityResponse checkEligibility(
            @PathVariable Integer rollNo,
            @PathVariable String subject) {

        return attendanceService.checkEligibility(rollNo, subject);
    }

}
