package com.example.myapplication;

public class VotersViews {
    public String uid, votername, voteraddress, voterdob, votergender, votercontact, voterprofile, voterbarcode;

    public VotersViews() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getVotername() {
        return votername;
    }

    public void setVotername(String votername) {
        this.votername = votername;
    }

    public String getVoteraddress() {
        return voteraddress;
    }

    public void setVoteraddress(String voteraddress) {
        this.voteraddress = voteraddress;
    }

    public String getVoterdob() {
        return voterdob;
    }

    public void setVoterdob(String voterdob) {
        this.voterdob = voterdob;
    }

    public String getVotergender() {
        return votergender;
    }

    public void setVotergender(String votergender) {
        this.votergender = votergender;
    }

    public String getVotercontact() {
        return votercontact;
    }

    public void setVotercontact(String votercontact) {
        this.votercontact = votercontact;
    }

    public String getVoterprofile() {
        return voterprofile;
    }

    public void setVoterprofile(String voterprofile) {
        this.voterprofile = voterprofile;
    }

    public String getVoterbarcode() {
        return voterbarcode;
    }

    public void setVoterbarcode(String voterbarcode) {
        this.voterbarcode = voterbarcode;
    }

    public VotersViews(String uid, String votername, String voteraddress, String voterdob, String votergender, String votercontact, String voterprofile, String voterbarcode) {
        this.uid = uid;
        this.votername = votername;
        this.voteraddress = voteraddress;
        this.voterdob = voterdob;
        this.votergender = votergender;
        this.votercontact = votercontact;
        this.voterprofile = voterprofile;
        this.voterbarcode = voterbarcode;
    }
}
