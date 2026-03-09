package com.thread;

public class AnonymousRunnable {

	public static void main(String[] args) {

		Runnable ob = () -> 
		{	
			for(int i=0;i<100;i++) {
				System.out.println("Hello");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		};
	    ob.run();


	}

}
