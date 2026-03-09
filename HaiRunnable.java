package com.thread;

class aa implements Runnable{
	public void run() {
		for(int i=0;i<100;i++) {
		System.out.println("SELVA");
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	}
}

class bb implements Runnable{
	public void run() {
		for(int i=0;i<100;i++) {
		System.out.println("SELVENDHIRAN");
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {e.printStackTrace();}
		}
		
	}
}



public class HaiRunnable {

	public static void main(String[] args) {
		
		aa A=new aa();
		bb B=new bb();
		
		Thread t1 = new Thread(A);
		Thread t2 = new Thread(B);
		
		t1.start();
		t2.start();

	}

}
