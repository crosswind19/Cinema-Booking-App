package com.example.groupproject;

import com.google.firebase.database.DataSnapshot;

public class UserProfile {
    public String EmailAddress;
    public String Name;
    public String Phone;

    public UserProfile(){

    }

    //public UserProfile(){}

    public UserProfile(String EmailAddress, String Name,String Phone) {
        this.EmailAddress = EmailAddress;
        this.Name = Name;
        this.Phone = Phone;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
