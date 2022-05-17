package lesson220517;

import java.util.concurrent.Semaphore;

import utils.Util;

public class Example37WaitForASignal {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		var sem = new Semaphore(0);
		
		new Thread(() -> {
			System.out.println("waiting for a signal...");
			sem.acquireUninterruptibly();  // waiting for a permit
			System.out.println("I've got a signal!");
		}).start();
		
		Util.pause(3000);
		
		sem.release();
		
	}

}
