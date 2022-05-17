package lesson220517;

import java.util.concurrent.Semaphore;

import utils.Util;

public class Example39ImitateCountDownLatch {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		var sem = new Semaphore(-2);
		
		new Thread(() -> {
			System.out.println("waiting for a signal...");
			sem.acquireUninterruptibly();  // waiting for a permit
			System.out.println("I've got a signal!");
		}).start();
		
		Util.pause(3000);
		
		System.out.println("one...");
		sem.release();
		Util.pause(1000);

		System.out.println("two...");
		sem.release();
		Util.pause(1000);
		
		System.out.println("three!");
		sem.release();
		
	}

}
