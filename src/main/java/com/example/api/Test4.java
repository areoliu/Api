package com.example.api;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Test4 {
    static Thread[] threads = new Thread[100];
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("finish");
            }
        });
        for(int i=0;i<100;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10000;j++){
                        int k=0;
                        k++;
                    }
                    System.out.println(Thread.currentThread().getName()+ new Date());
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    //System.out.println(Thread.currentThread().getName()+ new Date());
                }
            });

        }
        for(Thread thread:threads){
            thread.start();
        }

//        System.out.println(new Date());
//        countDownLatch.await();
//        System.out.println("main "+new Date());
    }
}
