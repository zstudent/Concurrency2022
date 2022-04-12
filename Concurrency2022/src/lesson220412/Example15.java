package lesson220412;

import utils.Util;

public class Example15 {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		Object mutex = new Object();
		
		Thread thread = new Thread(() -> {
			synchronized (mutex) {
				System.out.println("thread start");
				Util.pause(5000);
			}
		});
		thread.start();
		
		Util.pause(1000);
		
		thread.stop();
		
		synchronized (mutex) {
			System.out.println("got it!");
		}
		
	}

}
