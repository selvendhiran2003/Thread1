package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runnable_Callable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Runnable r = () -> {
			for(int i=0;i<10;i++) {
				System.out.println("Selva");
			}
		};
		
		Callable c = () -> {
			
			int a = 0;
			for(int i=1;i<=100;i++) {
				++a;
				System.out.println(a);
			}
			return a;
		};
	
		ExecutorService ex = Executors.newFixedThreadPool(2);
		
		ex.execute(r);
		Future<Integer> f=ex.submit(c);
		System.out.println(f.get());
		System.out.println(f.isDone());
		System.out.println("Main runs");
		
	}

}
