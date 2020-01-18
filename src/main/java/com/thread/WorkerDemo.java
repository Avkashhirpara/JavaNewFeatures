package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerDemo {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    private Random random = new Random();

    private void processOne(){
        synchronized (lock1)
        {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(100));
        }
    }
    private void processTwo(){
       synchronized (lock2)
        {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void executeAll(){
        for (int i = 0 ; i < 1000 ; i ++ ){
            processOne();
            processTwo();
        }
    }
    public void main(){
        System.out.println("Starting.....");
        long start = System.currentTimeMillis();
        Thread t = new Thread(() -> executeAll());
        Thread t2 = new Thread(this::executeAll);
        t.start();
        t2.start();

        try {
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time Taken "+ (end-start));
        System.out.println("list1 = "+ list1.size());
        System.out.println("list2 = "+ list2.size());
    }


    public static void main(String[] args) {
        new WorkerDemo().main();
    }


}
