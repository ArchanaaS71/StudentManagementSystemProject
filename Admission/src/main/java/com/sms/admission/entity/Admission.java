package com.sms.admission.entity;

import java.time.LocalDateTime;

import com.sms.admission.enums.AdmissionMode;
import com.sms.admission.enums.AdmissionStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "admission")
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Integer rollNo;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String address;
    private String fatherName;
    private String motherName;
    private String parentPhone;
    private String school;
    private Byte tenthPercentage;
    private Byte twelfthPercentage;

   
    private String department;

    @Enumerated(EnumType.STRING)
    private AdmissionMode admissionMode;

    @Enumerated(EnumType.STRING)
    private AdmissionStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "admission", cascade = CascadeType.ALL)
    private CounsellingAdmission counselling;

    @OneToOne(mappedBy = "admission", cascade = CascadeType.ALL)
    private ManagementAdmission management;

    @OneToOne(mappedBy = "admission", cascade = CascadeType.ALL)
    private ScholarshipAdmission scholarship;

    @OneToOne(mappedBy = "admission", cascade = CascadeType.ALL)
    private SportsAdmission sports;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Byte getTenthPercentage() {
		return tenthPercentage;
	}

	public void setTenthPercentage(Byte tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}

	public Byte getTwelfthPercentage() {
		return twelfthPercentage;
	}

	public void setTwelfthPercentage(Byte twelfthPercentage) {
		this.twelfthPercentage = twelfthPercentage;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public AdmissionMode getAdmissionMode() {
		return admissionMode;
	}

	public void setAdmissionMode(AdmissionMode admissionMode) {
		this.admissionMode = admissionMode;
	}

	public AdmissionStatus getStatus() {
		return status;
	}

	public void setStatus(AdmissionStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public CounsellingAdmission getCounselling() {
		return counselling;
	}

	public void setCounselling(CounsellingAdmission counselling) {
		this.counselling = counselling;
	}

	public ManagementAdmission getManagement() {
		return management;
	}

	public void setManagement(ManagementAdmission management) {
		this.management = management;
	}

	public ScholarshipAdmission getScholarship() {
		return scholarship;
	}

	public void setScholarship(ScholarshipAdmission scholarship) {
		this.scholarship = scholarship;
	}

	public SportsAdmission getSports() {
		return sports;
	}

	public void setSports(SportsAdmission sports) {
		this.sports = sports;
	}

	public Admission(Long id, Integer rollNo, String name, String email, String phone, String address,
			String fatherName, String motherName, String parentPhone, String school, Byte tenthPercentage,
			Byte twelfthPercentage, String department, AdmissionMode admissionMode, AdmissionStatus status,
			LocalDateTime createdAt, LocalDateTime updatedAt, CounsellingAdmission counselling,
			ManagementAdmission management, ScholarshipAdmission scholarship, SportsAdmission sports) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.parentPhone = parentPhone;
		this.school = school;
		this.tenthPercentage = tenthPercentage;
		this.twelfthPercentage = twelfthPercentage;
		this.department = department;
		this.admissionMode = admissionMode;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.counselling = counselling;
		this.management = management;
		this.scholarship = scholarship;
		this.sports = sports;
	}

	public Admission() {
		super();
	}

	
    
    
}