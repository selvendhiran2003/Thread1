package com.thread;

class Sharing{
	int count = 0;
	public  void inc() {
		synchronized(Sharing.class) {
		count++;
		}
	}
}
	
public class ClassLock {

	public static void main(String[] args) throws InterruptedException {
		Sharing sc = new Sharing();
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
