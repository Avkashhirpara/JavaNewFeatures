package com.java8.flatMap;

import com.practice.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students = Student.getList();
        List<Student> students2 = new ArrayList<>();
        students2 = Student.getList();

        List<List<Student>> list = new ArrayList<>();
        list.add(students);
        list.add(students2);

        List<Student> resultList = new ArrayList<>();
        System.out.println("list of list of students is "+ list);
        resultList = list.stream().flatMap(s-> s.stream()).collect(Collectors.toList());
        System.out.println("flat list of the students\n "+ resultList);

        // perform some operation before adding those students to result list after flattning.
        // students greater than 25 points

        resultList = list.stream().flatMap(s-> s.stream().filter(std->std.getPoint()>25)).collect(Collectors.toList());
        System.out.println("result of the students whose points are more than 25\n "+resultList);





    }
}
