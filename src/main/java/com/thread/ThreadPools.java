package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Worker implements Runnable{
    private int id;
    public Worker(int id) {
        this.id= id;
    }
    public void run(){
        System.out.println("Start worker + "+id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End worker + "+id);

    }
}

public class ThreadPools {

    public static void main(String[] args) {

        ExecutorService  executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(new Worker(i));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all task is completed..... ");


    }
}
