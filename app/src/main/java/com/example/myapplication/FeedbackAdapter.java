package com.example.myapplication;

public class FeedbackAdapter {
    private String name;
    private String email;
    private String contact;
    private String message;

    public FeedbackAdapter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FeedbackAdapter(String name, String email, String contact, String message) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.message = message;
    }

}
