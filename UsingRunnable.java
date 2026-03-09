package com.thread;


class Show implements Runnable{

	@Override
	public synchronized void run() {
		for(int i=0;i<5;i++) {
			if(i<2) {
				System.out.println("Normal bro");
			}
			else if(i==2) {
				System.out.println("5 second sleep bro");
				try {Thread.sleep(5000);} catch (InterruptedException e) {}
				System.out.println("Sleep bro");
			}
			else if(i==3) {
				System.out.println("Wait until notify enters");
				try {wait();} catch (InterruptedException e) {}
				System.out.println("At this time notify method calls");
			}
			else if(i==4) {
				System.out.println("At this time notify works");
				
			}
		}
	}
	public synchronized void notifying(){
		
		System.out.println("Notifying");
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
    	notify();
    	}

	
}

public class UsingRunnable {

	public static void main(String[] args) {
		
		Show sh = new Show();
	    Thread t1 = new Thread(sh);
	    Thread t2 = new Thread(() -> sh.notifying());
	    t1.start();
	    t2.start();
	}

}
