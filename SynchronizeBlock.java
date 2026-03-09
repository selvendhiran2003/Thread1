package com.thread;

class SharedClass1{
	int count = 0;
	public  void inc() {
		synchronized(this) {
		count++;
		}
	}
}
public class SynchronizeBlock {

	public static void main(String[] args) throws InterruptedException {
		SharedClass1 sc = new SharedClass1();
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
