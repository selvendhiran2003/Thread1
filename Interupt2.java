package com.thread;

public class Interupt2 {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(() -> {
			
			int k=0;
			while(true) {

				if(k==50) {
					try {
						Thread.sleep(1000);
						//k++;
					}
					catch (InterruptedException e) {
						System.out.println("Interupt bro");
					}
				}
				else if(k==100) 
				{
					Thread.currentThread().interrupt();
				}
				else 
				{
					k++;
					System.out.println(k);
				}
			}
		});
		t1.start();
		t1.interrupt();

	}

}
