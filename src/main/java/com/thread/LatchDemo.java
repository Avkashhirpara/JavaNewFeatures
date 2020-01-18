package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerOnLatch implements Runnable{
    private CountDownLatch latch;
    public WorkerOnLatch(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run(){
        System.out.println("Worker started.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker ended");
        latch.countDown();
    }
}
public class LatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.submit(new WorkerOnLatch(latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("completed.....");
    }
}
