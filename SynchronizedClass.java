package com.thread;

class SharesClass{
	public void shows() {
		synchronized(SharesClass.class) {
			for(int i=0;i<5;i++) {
				System.out.println(i);
			}
		}
	}
}

public class SynchronizedClass {

	public static void main(String[] args) {
		
		SharesClass sc1 = new SharesClass();
		sc1.shows();
		SharesClass sc2 = new SharesClass();
		sc2.shows();
	}

}
