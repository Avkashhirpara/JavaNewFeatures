package com.practice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public static List<Student> getList(){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(1,"Hanry",12,"32 B, BLACKER STREET"));
        studentList.add(new Student(2,"Peter",23,"33 B, BLACKER STREET"));
        studentList.add(new Student(3,"Richi",20,"3,north street. "));
        studentList.add(new Student(4,"Morgan",30,"90 A, Reven Avenue, Harlem"));
        studentList.add(new Student(5,"Steve",24,"R67, Marine drive, Miami"));
        studentList.add(new Student(6,"Bella",28,"596, Amber road, Surat"));
        studentList.add(new Student(7,"Monica",21,"234, Park road, Northboro"));
        studentList.add(new Student(8,"Julia",21,"B450, Train street, Boston"));
        studentList.add(new Student(9,"Mary",20,"7,Roger Avenue,26 Street"));
        studentList.add(new Student(9,"Mary",20,"7,Roger Avenue,26 Street"));
        return studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                point == student.point &&
                name.equals(student.name) &&
                address.equals(student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, point, address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", address='" + address + '\'' +
                "}\n";
    }
}
