package com.sms.admission.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "counselling_admission")
public class CounsellingAdmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cutoffMarks;

    @OneToOne
    @JoinColumn(name = "admission_id")
    private Admission admission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCutoffMarks() {
		return cutoffMarks;
	}

	public void setCutoffMarks(Integer cutoffMarks) {
		this.cutoffMarks = cutoffMarks;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public CounsellingAdmission(Long id, Integer cutoffMarks, Admission admission) {
		super();
		this.id = id;
		this.cutoffMarks = cutoffMarks;
		this.admission = admission;
	}

	public CounsellingAdmission() {
		super();
	}
    
}
