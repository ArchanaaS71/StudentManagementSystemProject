package com.sms.admission.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scholarship_admission")
public class ScholarshipAdmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scholarshipReason;
    private Integer marksObtained;

    @OneToOne
    @JoinColumn(name = "admission_id")
    private Admission admission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScholarshipReason() {
		return scholarshipReason;
	}

	public void setScholarshipReason(String scholarshipReason) {
		this.scholarshipReason = scholarshipReason;
	}

	public Integer getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Integer marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public ScholarshipAdmission(Long id, String scholarshipReason, Integer marksObtained, Admission admission) {
		super();
		this.id = id;
		this.scholarshipReason = scholarshipReason;
		this.marksObtained = marksObtained;
		this.admission = admission;
	}

	public ScholarshipAdmission() {
		super();
	}
    
}