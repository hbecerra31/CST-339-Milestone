package com.gcu.model;

import java.time.LocalDate;

public class ClaimModel {

	private String claimId;
    private String patientName;
    private String diagnosis;
    private LocalDate claimDate;
    private double claimAmount;

    // Constructors, getters, and setters

    public ClaimModel() {
        // Default constructor
    }

    public ClaimModel(String claimId, String patientName, String diagnosis, LocalDate claimDate, double claimAmount) {
        this.claimId = claimId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
    }

    // Getter and setter methods

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
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
        return "ClaimModel{" +
                "claimId='" + claimId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", claimDate=" + claimDate +
                ", claimAmount=" + claimAmount +
                '}';
    }
}
