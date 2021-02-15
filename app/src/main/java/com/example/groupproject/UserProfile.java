package com.example.groupproject;

import com.google.firebase.database.DataSnapshot;

public class UserProfile {
    public String emailAddress;
    public String name;
    public String phone;

    public UserProfile(String emailAddress, String name,String phone) {
        this.emailAddress = emailAddress;
        this.name = name;
        this.phone = phone;
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
