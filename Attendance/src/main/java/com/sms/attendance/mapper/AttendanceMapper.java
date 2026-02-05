package com.sms.attendance.mapper;

import com.sms.attendance.dto.response.AttendanceResponse;
import com.sms.attendance.entity.Attendance;

public class AttendanceMapper {

    private AttendanceMapper() {
        
    }

    public static AttendanceResponse toResponse(Attendance attendance) {

        AttendanceResponse response = new AttendanceResponse();
        response.setRollNo(attendance.getRollNo());
        response.setSubject(attendance.getSubject());
        response.setDate(attendance.getDate());
        response.setStatus(attendance.getStatus());

        return response;
    }
}
