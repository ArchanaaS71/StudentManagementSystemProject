package com.sms.admission.entity;

import com.sms.admission.enums.SportLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sports_admission")
public class SportsAdmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sportName;

    @Enumerated(EnumType.STRING)
    private SportLevel sportLevel;

    @OneToOne
    @JoinColumn(name = "admission_id")
    private Admission admission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public SportLevel getSportLevel() {
		return sportLevel;
	}

	public void setSportLevel(SportLevel sportLevel) {
		this.sportLevel = sportLevel;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public SportsAdmission(Long id, String sportName, SportLevel sportLevel, Admission admission) {
		super();
		this.id = id;
		this.sportName = sportName;
		this.sportLevel = sportLevel;
		this.admission = admission;
	}

	public SportsAdmission() {
		super();
	}
    
}
