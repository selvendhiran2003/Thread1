package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(() -> {
			System.out.println("Task running by "+Thread.currentThread().getName());
		});
		executor.shutdown();
	}

}
