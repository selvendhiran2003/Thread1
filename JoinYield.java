package com.thread;

class Shared{
	
	public void show()  {
		for(int i=0;i<=5;i++) {
			if(i<2) {
				System.out.println("hai Thread 1 "+i);
			}
			else if(i==3) {
				System.out.println("I am Oky to give Thread 2");
				//try {Thread.sleep(5000);} catch (InterruptedException e) {}
				Thread.yield();
				
			}
			else if(i==4||i==5) {
				System.out.println("hai Thread 1 "+i);
			}
		}
	}
	public void show1() {
		for(int i=0;i<=5;i++) {
			if(i<2) {
				System.out.println("hai Thread 2 "+i);
			}
			else if(i==3) {
				System.out.println("I am Oky to give Thread 1");
				try {Thread.sleep(5000);} catch (InterruptedException e) {}
				Thread.yield();
				
			}
			else if(i==4||i==5) {
				System.out.println("hai Thread 2 "+i);
			}
		}
	}
	
}

public class JoinYield {

	public static void main(String[] args) throws InterruptedException {
		
		Shared sc = new Shared();
		
		Thread t1 = new Thread(() -> {
			sc.show();
		});
		
		Thread t2 = new Thread(() -> {
			sc.show1();
		});
		t1.start();
		System.out.println(t1.isAlive());
		t2.start();
		t1.join();
		t2.join();
		System.out.println("MAIN CLOSED");
			
	}

}
