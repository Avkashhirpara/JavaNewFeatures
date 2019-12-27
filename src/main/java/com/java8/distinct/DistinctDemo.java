package com.java8.distinct;

import com.practice.domain.Employee;
import com.practice.domain.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistinctDemo {
    public static void main(String[] args) {
        List<Student> list = Student.getList();
        System.out.println("========================================================================");

        System.out.println(" the list of the students ");
        System.out.println(list);
        System.out.println("========================================================================");

        System.out.println("========================================================================");
        //apply distinct on the students
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct list of the student based on the equals method override in student class");
        System.out.println(list);
        System.out.println("========================================================================");

        // custom distinct as the distinct do not take any argument. there are several api which provides
        // distinct by etc. but lets write our own predicate and apply the filter which perform the same as distinct
        System.out.println("====================================================");
        list = distinctBy(list,Student::getPoint);
        System.out.println("here is the student list disticted by just the points");
        System.out.println(list);
        System.out.println("========================================================================");
        // generic distinc by will work on any list type

        System.out.println("=========================================================================");
        System.out.println("Employee list without distinct");
        List<Employee> employees = Employee.getList();
        System.out.println(employees);
        employees = distinctBy(employees,Employee::getRoll);
        System.out.println("distinct by the roll of employees ");
        System.out.println(employees);
        employees = Employee.getList();
        System.out.println("distinct by the employee salary");
        employees = distinctBy(employees,Employee::getSalary);
        System.out.println(employees);
    }

    public static <T,R>  List<T> distinctBy(List<T> list, Function<T,R> keyFunction){
        Set<R> setObject = new HashSet<>();
        List<T> newList = list.stream()
                .filter(std -> setObject.add(keyFunction.apply(std)))
                .collect(Collectors.toList());
        return newList;
    }

    /**
     * Simplified to understand the logic. This method only works with the student's list and the String
     * type attributes.
     * @param list
     * @param keyFunction
     * @return
     */
    public static  List<Student> simplyFiedDistinctBy(List<Student> list, Function<Student,String> keyFunction){
        Set<Student> setObject = new HashSet<>();
        List<Student> newList = new ArrayList<>();
        for (Student t : list) {
            if(! setObject.contains(keyFunction.apply(t))){
                    setObject.add(t);
                    newList.add(t);
            }
        }
        return newList;
    }


}
