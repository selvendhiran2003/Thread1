package com.thread;


class SharedClass{
	
	int num;
	boolean done = false;

	public synchronized void produce(int num) {

		while(done) {
			try {wait();} catch (InterruptedException e) {}
		}

		System.out.println("produce :"+num);
		this.num = num;
		done = true;
		notify();
	}
	public synchronized void consume() {
		while(!done) {
			try {wait();} catch (InterruptedException e) {}
		}
		System.out.println("consume :"+num);
		done = false;
		notify();
	}

}


class Producer implements Runnable{
	SharedClass sc;

	public Producer(SharedClass sc) {
		this.sc = sc;
		Thread t = new Thread(this,"Producer");
		t.start();
	}

	public void run() {
		int i=0;
		while(true) {
			sc.produce(i++);
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}

class Consumer implements Runnable {
	SharedClass sc;

	public Consumer(SharedClass sc) {
		this.sc = sc;
		Thread t = new Thread(this,"Consumer");
		t.start();
	}

	public void run() {
	
		while(true) {
			sc.consume();
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}


public class ProducerConsumer {

	public static void main(String[] args) {

		SharedClass sc=new SharedClass();
		Producer producer = new Producer(sc);
		Consumer consumer = new Consumer(sc);
	}

}
