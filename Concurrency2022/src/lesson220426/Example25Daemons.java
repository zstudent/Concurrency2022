package lesson220426;

import utils.Util;

public class Example25Daemons {
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(() -> {
			while (true) {
				System.out.println(Thread.currentThread());
				Util.pause(1000);
			}
		});
		thread.setDaemon(true);
		thread.start();
		
		Util.pause(5000);
		
	}

}
