package com.thread;

class CheckBro{
	public void check() {
		for(int i=0;i<100;i++) {
			System.out.println("Selva");
		}
	}
}

public class SetPriority {

	public static void main(String[] args) throws InterruptedException {

		CheckBro cb = new CheckBro();

		Thread t1 = new Thread(() -> {
			for(int i=0;i<100;i++)
				System.out.println("Selva "+Thread.currentThread().getPriority());
			},"T1");
		Thread t2 = new Thread(() -> {
			for(int i=0;i<100;i++)
				System.out.println("Selvabro "+Thread.currentThread().getPriority());
			},"T2");
		
		t1.setPriority(10);
		t2.setPriority(1);
		t1.start();
		t2.start();
		
		System.out.println("Bye");

	}

}
