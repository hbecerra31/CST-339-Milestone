package com.gcu.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CLAIMS")
public class ClaimEntity {
	
	@Id
	private Long claimId;
	
	@Column("PATIENT_NAME")
	private String patientName;
	
	@Column("DIAGNOSIS")
	private String diagnosis;
	
	@Column("CLAIM_DATE")
	private LocalDate claimDate;
	
	@Column("CLAIM_AMOUNT")
	private double claimAmount;
	
	public ClaimEntity() {
		
	}
	
	public ClaimEntity(Long claimId, String patientName, String diagnosis, LocalDate claimDate, double claimAmount) {
		this.claimId = claimId;
		this.patientName = patientName;
		this.diagnosis = diagnosis;
		this.claimDate = claimDate;
		this.claimAmount = claimAmount;
	}

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	

}
