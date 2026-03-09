package com.thread;



public class Interupt {

	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			int k=0;
			while(true) {
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Stopping");
					break;
				}
				else if(k==100) {
					Thread.currentThread().interrupt();
					continue;
				}
				else {
					k++;
					System.out.println(k);
				}
			}
		});
		t1.start();
		//t1.interrupt();
	}
}
