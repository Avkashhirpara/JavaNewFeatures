package com.java8.lambda;

import com.practice.domain.Employee;

import java.sql.SQLOutput;

public class FunctionDemo {

   static myFunction<String,Integer> myfunction = s -> s.length();

    public static void main(String[] args) {
        //simple functions
        System.out.println(myfunction.filter("String "));

        // lambda that modify the list objects
        // increase the salary of the employee based on the current package.



    }


}

interface myFunction<T,R> {
    R filter(T t);
}

interface IncreaseSalary{
    public Employee setNew();
}