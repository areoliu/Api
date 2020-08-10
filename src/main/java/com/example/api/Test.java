package com.example.api;

public class Test {

    private static volatile boolean flag=false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" is ready");
                while (!flag){

                }
                System.out.println(Thread.currentThread().getName()+" is finish");
            }
        }).start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" is ready");
                flag=true;
                System.out.println(Thread.currentThread().getName()+" is finish");
            }
        }).start();
    }
}