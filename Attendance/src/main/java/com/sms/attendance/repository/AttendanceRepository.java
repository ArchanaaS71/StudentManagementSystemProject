package com.sms.attendance.repository;

import com.sms.attendance.dto.response.AttendanceResponse;
import com.sms.attendance.entity.Attendance;
import com.sms.attendance.enums.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByRollNo(Integer rollNo);

    List<Attendance> findByRollNoAndSubject(Integer rollNo, String subject);

    Long countByRollNoAndSubject(Integer rollNo, String subject);

    Long countByRollNoAndSubjectAndStatus(
            Integer rollNo,
            String subject,
            AttendanceStatus status
    );

}

