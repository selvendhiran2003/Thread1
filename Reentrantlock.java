package com.thread;

import java.util.concurrent.locks.ReentrantLock;

class Counter{
	ReentrantLock lock = new ReentrantLock();
	int count = 0;
	public void increament() {
		lock.lock();
		try {
			count++;
			System.out.println(Thread.currentThread().getName()+" : "+count);
		}
		finally {
			lock.unlock();
		}
	}
}

public class Reentrantlock {

	public static void main(String[] args) {
		
		Counter cnt = new Counter();
		Thread t1 = new Thread(() -> {
			for(int i=0;i<5;i++) 
				cnt.increament();
		});;
		Thread t2 = new Thread(() -> {
			for(int i=0;i<5;i++)
				cnt.increament();
		});
		t1.start();
		t2.start();
	}

}
