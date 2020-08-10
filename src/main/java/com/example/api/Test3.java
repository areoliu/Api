package com.example.api;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Test3 {
    static Thread[] threads = new Thread[100];
    static CountDownLatch  countDownLatch =new CountDownLatch(100);
    public static void main(String[] args) throws InterruptedException {

        System.out.println(new Date());
        for(int i=0;i<100;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10000;j++){
                        int k=0;
                        k++;
                    }
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch.countDown();
                }
            });

        }
        for(Thread thread:threads){
            thread.start();
        }

        System.out.println(new Date());
        countDownLatch.await();
        System.out.println("main "+new Date());
    }
}
