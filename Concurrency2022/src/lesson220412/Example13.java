package lesson220412;

import utils.Util;

public class Example13 {
	
	public static void main(String[] args) {
		
		Object mutex = new Object();
		
		new Thread(() -> {
			System.out.println("thread started");
			synchronized (mutex) {
				System.out.println("Got it! " + Thread.currentThread());
			}
		}).start();
		
		
		synchronized (mutex) {
			System.out.println("got it! " + Thread.currentThread());
			Util.pause(60000);
			System.out.println("released it! " + Thread.currentThread());
			
		}
		
	}

}
