package com.example.myapplication;

public class VoterRegistration {
    private String votersId;
    private String fullName;
    private String fatherName;
    private String uniqueId;
    private String mobileNumber;
    private String birthDate;
    private String emailId;
    private String addressOne;
    private String addressTwo;
    private String voterState;
    private String voterDistrict;
    private String voterPin;
    private String gender;


    public String getGender() {
        return gender;
    }

    public VoterRegistration(String id, String fullName) {
    }


    public VoterRegistration(String fullName) {
    }

    public String getFullName() {
        return fullName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public String getVoterState() {
        return voterState;
    }

    public String getVoterDistrict() {
        return voterDistrict;
    }



    public String getVoterPin() {
        return voterPin;
    }
    public String getVotersIdPin() {
        return votersId;
    }

    public VoterRegistration(String votersId,String fullName, String fatherName, String uniqueId, String mobileNumber, String birthDate, String emailId, String addressOne, String addressTwo, String voterState, String voterDistrict, String voterPin, String gender) {
        this.fullName = fullName;
        this.fatherName = fatherName;
        this.uniqueId = uniqueId;
        this.mobileNumber = mobileNumber;
        this.birthDate = birthDate;
        this.emailId = emailId;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.voterState = voterState;
        this.voterDistrict = voterDistrict;
        this.voterPin = voterPin;
        this.votersId = votersId;
        this.gender = gender;

    }
}
