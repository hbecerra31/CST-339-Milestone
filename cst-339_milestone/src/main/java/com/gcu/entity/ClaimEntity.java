package com.gcu.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity class representing a claim in the application.
 */
@Document(collection = "claims")
public class ClaimEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private int claimId;

    private String patientName;

    private String diagnosis;

    private LocalDate claimDate;

    private double claimAmount;

    /**
     * Default constructor for ClaimEntity.
     */
    public ClaimEntity() {

    }

    /**
     * Parameterized constructor for ClaimEntity.
     *
     * @param id          The Document ID.
     * @param claimId     The claim ID.
     * @param patientName The patient name.
     * @param diagnosis   The diagnosis.
     * @param claimDate   The claim date.
     * @param claimAmount The claim amount.
     */
    public ClaimEntity(String id, int claimId, String patientName, String diagnosis, LocalDate claimDate,
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
     * @return The Document ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the Document ID.
     *
     * @param id The Document ID to set.
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
}
