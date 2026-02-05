package com.sms.admission.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "management_admission")
public class ManagementAdmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referralName;
    private String referralContact;

    @OneToOne
    @JoinColumn(name = "admission_id")
    private Admission admission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferralName() {
		return referralName;
	}

	public void setReferralName(String referralName) {
		this.referralName = referralName;
	}

	public String getReferralContact() {
		return referralContact;
	}

	public void setReferralContact(String referralContact) {
		this.referralContact = referralContact;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public ManagementAdmission(Long id, String referralName, String referralContact, Admission admission) {
		super();
		this.id = id;
		this.referralName = referralName;
		this.referralContact = referralContact;
		this.admission = admission;
	}

	public ManagementAdmission() {
		super();
	}
    
	
}

