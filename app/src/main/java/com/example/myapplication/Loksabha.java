package com.example.myapplication;

public class Loksabha {
   public String partyname, recievedseats, recievedvote, status, totalvotes, voteshare, partylogo;

    public Loksabha() {
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public String getRecievedseats() {
        return recievedseats;
    }

    public void setRecievedseats(String recievedseats) {
        this.recievedseats = recievedseats;
    }

    public String getRecievedvote() {
        return recievedvote;
    }

    public void setRecievedvote(String recievedvote) {
        this.recievedvote = recievedvote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalvotes() {
        return totalvotes;
    }

    public void setTotalvotes(String totalvotes) {
        this.totalvotes = totalvotes;
    }

    public String getVoteshare() {
        return voteshare;
    }

    public void setVoteshare(String voteshare) {
        this.voteshare = voteshare;
    }

    public String getPartylogo() {
        return partylogo;
    }

    public void setPartylogo(String partylogo) {
        this.partylogo = partylogo;
    }

    public Loksabha(String partyname, String recievedseats, String recievedvote, String status, String totalvotes, String voteshare, String partylogo) {
        this.partyname = partyname;
        this.recievedseats = recievedseats;
        this.recievedvote = recievedvote;
        this.status = status;
        this.totalvotes = totalvotes;
        this.voteshare = voteshare;
        this.partylogo = partylogo;
    }


}
