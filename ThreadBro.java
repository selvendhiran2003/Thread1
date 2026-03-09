package com.thread;


class Hai extends Thread{ 
	public void run() {
		System.out.println("SELVA");	
		}
}

public class ThreadBro {

	public static void main(String[] args) {
		
		Hai hi = new Hai();
		Hai hi1 = new Hai();
		hi.start();
		hi1.start();
		
	}

}
