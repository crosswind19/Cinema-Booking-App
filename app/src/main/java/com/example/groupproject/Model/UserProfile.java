package com.example.groupproject.Model;

public class UserProfile {
    private String emailAddress;
    private String name;
    private String phone;

    public UserProfile(String emailAddress, String name,String phone) {
        this.emailAddress = emailAddress;
        this.name = name;
        this.phone = phone;
    }

    public UserProfile() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
