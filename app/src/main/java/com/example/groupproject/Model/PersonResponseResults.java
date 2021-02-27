package com.example.groupproject.Model;

import java.util.List;

public class PersonResponseResults {
    private boolean adult;
    private int gender;
    private Integer id;
    private List<PersonResponseResultsKnownFor> known_for;
    private String known_for_department;
    private String name;
    private double popularity;
    private String profile_path;

    public PersonResponseResults() {
    }

    public PersonResponseResults(boolean adult, int gender, Integer id, List<PersonResponseResultsKnownFor> known_for, String known_for_department, String name, double popularity, String profile_path) {
        this.adult = adult;
        this.gender = gender;
        this.id = id;
        this.known_for = known_for;
        this.known_for_department = known_for_department;
        this.name = name;
        this.popularity = popularity;
        this.profile_path = profile_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PersonResponseResultsKnownFor> getKnown_for() {
        return known_for;
    }

    public void setKnown_for(List<PersonResponseResultsKnownFor> known_for) {
        this.known_for = known_for;
    }

    public String getKnown_for_department() {
        return known_for_department;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
