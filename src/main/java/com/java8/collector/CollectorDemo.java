package com.java8.collector;

import com.practice.domain.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorDemo {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getList();
        System.out.println("list of the employees");
        System.out.println(employees);
        Map<String,List<Employee>> empByRoll = employees.stream().collect(Collectors.groupingBy(Employee::getRoll));
        System.out.println("Employee grouped by the Roll. ");
        System.out.println(empByRoll);
        //It is highly suggested to explore the largest number of solutions possible for the problem at hand,
        // but always choose the most specialised one that's general enough for to solve It.

    }

}
