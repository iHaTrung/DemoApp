package com.example.testapplication3.model;

import android.media.Image;

public class Student {
    String id;
    String name;
    String gender;
    String date;

    public Student(String id, String name, String gender, String date) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
