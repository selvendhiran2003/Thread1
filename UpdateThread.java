package com.thread;



class Book extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Updating..");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Num extends Thread{
	public void run()  {
		for(int i=0;i<5;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}




public class UpdateThread {

	public static void main(String[] args) throws InterruptedException {
		Book b = new Book();
		Num n = new Num();
		b.start();
		n.start();
		b.join();
		n.join();
		System.out.println("Bye");
	}

}
