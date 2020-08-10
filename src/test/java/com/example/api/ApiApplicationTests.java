package com.example.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

	private  boolean flag=false;
	@Test
	void contextLoads() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" is ready");
				while (!flag){

				}
				System.out.println(Thread.currentThread().getName()+" is finish");
			}
		}).start();

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
