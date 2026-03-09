package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Counter1{
	int count = 0;
	public void increament() {
		count++;
		System.out.println(count+" "+Thread.currentThread().getName());
	}
}

public class Executor_Service {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter1 cnt = new Counter1();
		ExecutorService ex = Executors.newFixedThreadPool(2);
		
		ex.execute(()->{
			for(int i=0;i<2000;i++) {
				cnt.increament();
			}
		});
		ex.execute(()->{
			for(int i=0;i<2000;i++) {
				cnt.increament();
			}
		});
		ex.execute(()->{
			for(int i=0;i<2000;i++) {
				cnt.increament();
			}
		});
		ex.execute(()->{
			for(int i=0;i<2000;i++) {
				cnt.increament();
			}
		});
		ex.shutdown();
	}

}
