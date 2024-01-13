package com.gcu.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

/**
 * Model class representing a claim entity.
 */
public class ClaimModel {

	private String id;

	private int claimId;

	@NotBlank(message = "Patient name cannot be blank")
	private String patientName;

	@NotBlank(message = "Diagnosis cannot be blank")
	private String diagnosis;

	@NotNull(message = "Claim date cannot be blank")
	@PastOrPresent(message = "Claim date must be in the past or present")
	private LocalDate claimDate;

	@Positive(message = "Claim amount must be a positive value")
	private double claimAmount;

	/**
	 * Default constructor.
	 */
	public ClaimModel() {

	}

	/**
	 * Parameterized constructor to initialize the claim entity.
	 *
	 * @param id          The ID of the Document
	 * @param claimId     The ID of the claim.
	 * @param patientName The name of the patient.
	 * @param diagnosis   The diagnosis associated with the claim.
	 * @param claimDate   The date of the claim.
	 * @param claimAmount The amount claimed.
	 */
	public ClaimModel(String id, int claimId, String patientName, String diagnosis, LocalDate claimDate,
			double claimAmount) {
		this.id = id;
		this.claimId = claimId;
		this.patientName = patientName;
		this.diagnosis = diagnosis;
		this.claimDate = claimDate;
		this.claimAmount = claimAmount;
	}

	/**
	 * Gets the Document ID.
	 * 
	 * @return the Document ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the Document ID.
	 * 
	 * @param id Document ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the claim ID.
	 *
	 * @return The claim ID.
	 */
	public int getClaimId() {
		return claimId;
	}

	/**
	 * Sets the claim ID.
	 *
	 * @param claimId The claim ID to set.
	 */
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	/**
	 * Gets the patient name.
	 *
	 * @return The patient name.
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * Sets the patient name.
	 *
	 * @param patientName The patient name to set.
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * Gets the diagnosis.
	 *
	 * @return The diagnosis.
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * Sets the diagnosis.
	 *
	 * @param diagnosis The diagnosis to set.
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * Gets the claim date.
	 *
	 * @return The claim date.
	 */
	public LocalDate getClaimDate() {
		return claimDate;
	}

	/**
	 * Sets the claim date.
	 *
	 * @param claimDate The claim date to set.
	 */
	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	/**
	 * Gets the claim amount.
	 *
	 * @return The claim amount.
	 */
	public double getClaimAmount() {
		return claimAmount;
	}

	/**
	 * Sets the claim amount.
	 *
	 * @param claimAmount The claim amount to set.
	 */
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	/**
	 * Overrides the default toString method for better logging or debugging.
	 *
	 * @return A string representation of the ClaimModel.
	 */
	@Override
	public String toString() {
		return "ClaimModel{" + 
							"id='" + id + '\'' + 
							", claimId='" + claimId + '\'' + 
							", patientName='" + patientName+ '\'' + 
							", diagnosis='" + diagnosis + '\'' + 
							", claimDate=" + claimDate + 
							", claimAmount=" + claimAmount + '}';
	}
}
