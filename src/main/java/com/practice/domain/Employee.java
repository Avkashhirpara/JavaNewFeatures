package com.practice.domain;

public class Employee {
    private int id;
    private double salary;
    private String name ;
    private String roll;

    public Employee(int id, double salary, String name, String roll) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.roll = roll;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
}
