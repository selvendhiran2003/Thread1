package com.thread;


class SharedClass{
	int count = 0;
	public synchronized void inc() {
		count++;
	}
}
public class Synchronized {

	public static void main(String[] args) throws InterruptedException {
		SharedClass sc = new SharedClass();
		
		Thread t1 = new Thread(() -> {
			for(int i=0;i<500;i++)
			sc.inc();
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=0;i<500;i++)
			sc.inc();
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(sc.count);
	}

}
