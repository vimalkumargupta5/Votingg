package com.example.myapplication;

public class Announcement {

    public String subject,contents;

    public Announcement() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Announcement(String subject, String contents) {
        this.subject = subject;
        this.contents = contents;
    }
}
