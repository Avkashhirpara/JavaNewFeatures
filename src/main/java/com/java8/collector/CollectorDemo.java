package com.java8.collector;

import com.practice.domain.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CollectorDemo {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getList().stream().sorted(Comparator.comparing(Employee::getRoll)).collect(toList());
        System.out.println("list of the employees");
        System.out.println(employees);
        Map<String,List<Employee>> empByRoll = employees.stream().collect(groupingBy(Employee::getRoll));
        System.out.println("Employee grouped by the Roll. ");
        System.out.println(empByRoll);
        //It is highly suggested to explore the largest number of solutions possible for the problem at hand,
        // but always choose the most specialised one that's general enough for to solve It.

        System.out.println("===========================================================");
         Map<Boolean,Map<String,List<Employee>>> newmap = employees.stream().collect(
                 partitioningBy(emp-> emp.getSalary() > 30000 , groupingBy(Employee::getRoll)));
        System.out.println("partition by the salary greater then 30000 and less then 30000");
        System.out.println(newmap);

        System.out.println("===========================================================================");
        System.out.println("Get maximum salaried employees from each department. ");

        Map<String, Optional<Employee>> maxSalPerDept =  employees.stream().collect(groupingBy(Employee::getRoll,maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(maxSalPerDept);
        System.out.println("=================================================================================");
        System.out.println("total salary per department ");
        Map<String,Double> totalSalPerDept =
                employees.stream().collect(groupingBy(Employee::getRoll,summingDouble(Employee::getSalary)));
        System.out.println(totalSalPerDept);


    }

}
