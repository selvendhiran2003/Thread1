package com.thread;

public class DeadLock {

	public static void main(String[] args) {
		
		String str1 = "Selva";
		String str2 = "Indhiran";
		
		Thread t1 = new Thread(() -> {
			synchronized(str1) {
				System.out.println(Thread.currentThread().getName()+" locked "+str1);
				try {Thread.sleep(1000);} catch (InterruptedException e) {}
				synchronized(str2) {
					System.out.println(str1+str2);
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			synchronized(str2) {
				System.out.println(Thread.currentThread().getName()+" locked "+str2);
				
				synchronized(str1) {
					System.out.println(str1+str2);
				}
			}
		});
		
		t1.start();
		t2.start();
		
	}
}
