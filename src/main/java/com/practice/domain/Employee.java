package com.practice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private int id;
    private double salary;
    private String name ;
    private String roll;

    public Employee(int id,  String name,double salary, String roll) {
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


    public static List<Employee> getList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Hanry",20000,"DESIGNER"));
        employeeList.add(new Employee(2,"Peter",20000,"QA"));
        employeeList.add(new Employee(3,"Richi",35000,"DESIGNER"));
        employeeList.add(new Employee(4,"Morgan",50000,"MANAGER"));
        employeeList.add(new Employee(5,"Steve",90000,"TL"));
        employeeList.add(new Employee(6,"Bella",60000,"DEV"));
        employeeList.add(new Employee(7,"Monica",55000,"DEV"));
        employeeList.add(new Employee(8,"Julia",15000,"QA"));
        employeeList.add(new Employee(9,"Mary",46000,"MANAGER"));
        return employeeList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                "} \n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                name.equals(employee.name) &&
                roll.equals(employee.roll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, name, roll);
    }
}
