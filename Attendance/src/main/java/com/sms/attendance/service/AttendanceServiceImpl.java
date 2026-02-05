package com.sms.attendance.service;

import com.sms.attendance.client.StudentClient;
import com.sms.attendance.dto.request.BulkAttendanceRequest;
import com.sms.attendance.dto.request.MarkAttendanceRequest;
import com.sms.attendance.dto.response.AttendanceResponse;
import com.sms.attendance.dto.response.AttendanceSummaryResponse;
import com.sms.attendance.entity.Attendance;
import com.sms.attendance.enums.AttendanceStatus;
import com.sms.attendance.mapper.AttendanceMapper;
import com.sms.attendance.repository.AttendanceRepository;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentClient studentClient;

    public AttendanceServiceImpl(
            AttendanceRepository attendanceRepository,
            StudentClient studentClient) {

        this.attendanceRepository = attendanceRepository;
        this.studentClient = studentClient;
    }

    @Override
    public AttendanceResponse markAttendance(MarkAttendanceRequest request) {

        try {
            studentClient.getStudentByRoll(request.getRollNo());
        } catch (Exception ex) {
            throw new RuntimeException("Invalid roll number. Student not found.");
        }

        Attendance attendance = new Attendance();
        attendance.setRollNo(request.getRollNo());
        attendance.setSubject(request.getSubject());
        attendance.setDate(request.getDate());
        attendance.setStatus(request.getStatus());

        Attendance saved = attendanceRepository.save(attendance);
        return AttendanceMapper.toResponse(saved);
    }

    @Override
    public List<AttendanceResponse> getAttendanceByRollNo(Integer rollNo) {

        return attendanceRepository.findByRollNo(rollNo)
                .stream()
                .map(AttendanceMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AttendanceResponse> getAttendanceBySubject(
            Integer rollNo, String subject) {

        return attendanceRepository.findByRollNoAndSubject(rollNo, subject)
                .stream()
                .map(AttendanceMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceSummaryResponse getAttendanceSummary(
            Integer rollNo, String subject) {

        Long total = attendanceRepository
                .countByRollNoAndSubject(rollNo, subject);

        Long present = attendanceRepository
                .countByRollNoAndSubjectAndStatus(
                        rollNo, subject, AttendanceStatus.PRESENT);

        AttendanceSummaryResponse summary = new AttendanceSummaryResponse();
        summary.setRollNo(rollNo);
        summary.setSubject(subject);
        summary.setTotalClasses(total);
        summary.setPresentCount(present);

        double percentage = total == 0
                ? 0.0
                : (present * 100.0) / total;

        summary.setAttendancePercentage(percentage);

        return summary;
    }
    @Override
    public List<AttendanceResponse> markBulkAttendance(BulkAttendanceRequest request) {

        List<Attendance> savedRecords = new ArrayList<>();

        for (Integer rollNo : request.getRollNos()) {

            
            try {
                studentClient.getStudentByRoll(rollNo);
            } catch (Exception ex) {
                throw new RuntimeException(
                    "Invalid roll number: " + rollNo
                );
            }

            Attendance attendance = new Attendance();
            attendance.setRollNo(rollNo);
            attendance.setSubject(request.getSubject());
            attendance.setDate(request.getDate());
            attendance.setStatus(request.getStatus());

            savedRecords.add(attendance);
        }

        return attendanceRepository.saveAll(savedRecords)
                .stream()
                .map(AttendanceMapper::toResponse)
                .collect(Collectors.toList());
    }

}
