package com.example.myapplication;

public class Candidates {
    public String name,image,domain,place,status,age,partylogo,candidateqr,candidateuid;


    public Candidates(){

    }

    public String getCandidateqr() {
        return candidateqr;
    }

    public void setCandidateqr(String candidateqr) {
        this.candidateqr = candidateqr;
    }

    public String getCandidateuid() {
        return candidateuid;
    }

    public void setCandidateuid(String candidateuid) {
        this.candidateuid = candidateuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }
    public String getPartylogo(){
        return partylogo;
    }
    public void setPartylogo(String partylogo){
        this.partylogo = partylogo;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Candidates(String name, String image, String domain, String place, String status, String age, String partylogo, String candidateqr, String candidateuid) {
        this.name = name;
        this.image = image;
        this.domain = domain;
        this.place = place;
        this.status = status;
        this.age = age;
        this.partylogo = partylogo;
        this.candidateqr = candidateqr;
        this.candidateuid = candidateuid;
    }
}
