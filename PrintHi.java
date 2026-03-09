package com.thread;

class a extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
		System.out.println("SELVA");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	}
}

class b extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
		System.out.println("SELVENDHIRAN");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {e.printStackTrace();}
		}
		
	}
}

public class PrintHi {

	public static void main(String[] args) {
		
		a A=new a();
		b B=new b();
		
		A.start();
		B.start();

	}

}
