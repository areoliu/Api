package com.example.api;

import java.util.concurrent.locks.ReentrantLock;

public class Test2 {

    private static volatile boolean flag=false;
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++) {
                    try {

                        reentrantLock.lock();
                        System.out.println(Thread.currentThread().getName() + " is finish " + i);

                    } catch (Exception e) {

                    } finally {
                        reentrantLock.unlock();
                    }
                }


            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++) {
                    try {

                        reentrantLock.lock();
                        System.out.println(Thread.currentThread().getName() + " is finish " + i);

                    } catch (Exception e) {

                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        }).start();
    }
}