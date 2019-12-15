package com.java8.lambda;

import com.practice.domain.Student;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args)
    {

        // simple predicate
        Predicate<String> isSmallString = s -> s.length() < 10;
        System.out.println(" \"this\" ,is it a small string?? : "+ isSmallString.test("this"));
        System.out.println(" \"Hello how are you \" ,is it a small string?? : "+ isSmallString.test("Hello how are you"));


        // is the given student is brilliant or dumb.
        Student s = new Student(1,"Henry",12,"21,Arial Street");
        Predicate<Student> academicScore = std -> std.getPoint() > 20 ;
        if (academicScore.test(s)){
            System.out.println(s.getName()+ "has good academic score");
        }else{
            System.out.println(s.getName()+ " has long way to go when it comes to score.");
        }
    }



}
