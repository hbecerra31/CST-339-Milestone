package com.gcu.model;

import java.time.LocalDate;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public class ClaimModel {

	@NotNull (message = "Claim ID cannot be blank")
	@Positive(message = "Claim ID must be a positive value")
	private Integer claimId;

	@NotBlank(message = "Patient name cannot be blank")
	private String patientName;

	@NotBlank(message = "Diagnosis cannot be blank")
	private String diagnosis;

	@NotNull (message = "Claim date cannot be blank")
	@PastOrPresent(message = "Claim date must be in the past or present")
	private LocalDate claimDate;

	@Positive(message = "Claim amount must be a positive value")
	private double claimAmount;

	// Constructors

	// Default constructor
	public ClaimModel() {
	}

	public ClaimModel(Integer claimId, String patientName, String diagnosis, LocalDate claimDate, double claimAmount) {
		this.claimId = claimId;
		this.patientName = patientName;
		this.diagnosis = diagnosis;
		this.claimDate = claimDate;
		this.claimAmount = claimAmount;
	}

	// Getter and setter methods

	public Integer getClaimId() {
		return claimId;
	}

	public void setClaimId(Integer claimId) {
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

	// toString method for better logging or debugging

	@Override
	public String toString() {
		return "ClaimModel{" + "claimId='" + claimId + '\'' + ", patientName='" + patientName + '\'' + ", diagnosis='"
				+ diagnosis + '\'' + ", claimDate=" + claimDate + ", claimAmount=" + claimAmount + '}';
	}
}
