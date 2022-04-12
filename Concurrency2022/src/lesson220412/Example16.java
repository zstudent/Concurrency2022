package lesson220412;

import utils.Util;

public class Example16 {
	
	public static void main(String[] args) {
		
		Object  mutex = new Object ();

		synchronized (mutex) {
			for (int i = 0; i < 5; i++) {
				new Thread(() -> {
					synchronized (mutex) {
						System.out.println("got it " + Thread.currentThread());
					}
				}).start();
			}
			System.out.println("acquiring in main...");
			Util.pause(30000);
			System.out.println("released in main...");
		}
		
		
	}

}
