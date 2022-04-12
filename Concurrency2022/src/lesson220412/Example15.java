package lesson220412;

import java.lang.Thread.State;

import utils.Util;

public class Example15 {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		Object mutex = new Object();
		
		Thread thread = new Thread(() -> {
			synchronized (mutex) {
				System.out.println("thread start");
			}
		});
		
		synchronized (mutex) {
			thread.start();
			Util.pause(1000);
			thread.stop();
			// now if we check, the thread will remain blocked forever
			while(thread.getState() != State.TERMINATED) {
				Util.pause(1000); 
				System.out.println(thread.getState());
			}
		}
		
	}

}
