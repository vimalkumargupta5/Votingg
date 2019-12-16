package com.example.myapplication;

public class PoliticalParties {
    public String partyname, founded, partychief, politicalpartylogo;

    public PoliticalParties() {
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getPartychief() {
        return partychief;
    }

    public void setPartychief(String partychief) {
        this.partychief = partychief;
    }

    public String getPoliticalpartylogo() {
        return politicalpartylogo;
    }

    public void setPoliticalpartylogo(String politicalpartylogo) {
        this.politicalpartylogo = politicalpartylogo;
    }

    public PoliticalParties(String partyname, String founded, String partychief, String politicalpartylogo) {
        this.partyname = partyname;
        this.founded = founded;
        this.partychief = partychief;
        this.politicalpartylogo = politicalpartylogo;
    }
}
