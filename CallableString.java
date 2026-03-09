package com.thread;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableString {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
 
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		
		Future<?> f=  es.submit(() -> {
			 String name = "Selva";
			 Thread.currentThread().sleep(1000);
			 return name;
		});
		
		System.out.println("Main");//Asynchronous
		System.out.println(f.get());
		es.shutdown();
	}

}
