package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableDemo implements Callable<Long>{
	
	int num;
	CallableDemo(int num){
		this.num=num;
	}
	
	public Long call() {
		long fact = 1;
		for(int i=1;i<num;i++) {
			fact*=i;
		}
		return fact;
	}
}
public class Callable1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CallableDemo c = new CallableDemo(10);
		
		ExecutorService executor=Executors.newFixedThreadPool(2);
		
		Future<Long> res=executor.submit(c);
		System.out.println(res.get());
		
		executor.shutdown();
	}
}
