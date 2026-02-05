package com.sms.admission.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.admission.entity.Admission;

public interface AdmissionRepository extends JpaRepository<Admission,Long> {
	  List<Admission> findByDepartmentIgnoreCase(String department);

	boolean existsByEmail(String email);

}
