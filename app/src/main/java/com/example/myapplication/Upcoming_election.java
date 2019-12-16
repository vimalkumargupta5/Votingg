package com.example.myapplication;

public class Upcoming_election {
    public String year, electiontype, detail, state, map;

    public Upcoming_election() {
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getElectiontype() {
        return electiontype;
    }

    public void setElectiontype(String electiontype) {
        this.electiontype = electiontype;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Upcoming_election(String year, String electiontype, String detail, String state, String map) {
        this.year = year;
        this.electiontype = electiontype;
        this.detail = detail;
        this.state = state;
        this.map = map;
    }
}
