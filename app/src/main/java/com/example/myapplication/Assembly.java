package com.example.myapplication;

public class Assembly {
    public String cm, flag, rullingparty, state;

    public Assembly() {
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRullingparty() {
        return rullingparty;
    }

    public void setRullingparty(String rullingparty) {
        this.rullingparty = rullingparty;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Assembly(String cm, String flag, String rullingparty, String state) {
        this.cm = cm;
        this.flag = flag;
        this.rullingparty = rullingparty;
        this.state = state;
    }
}
