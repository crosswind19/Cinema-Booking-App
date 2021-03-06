package com.example.groupproject.Model;

public class Feedbacks {
    String username;
    String message;

    public Feedbacks(){

    }

    public Feedbacks(String username, String feedback){
        this.username = username;
        this.message = feedback;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
