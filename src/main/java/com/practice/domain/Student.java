package com.practice.domain;

public class Student {
    private int id;
    private String name;
    private int point;
    private String address;

    public Student(int id, String name, int point, String address) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
