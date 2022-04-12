package lesson220412;

import utils.Util;

public class Example17SignalWithInterrupt {

	public static void main(String[] args) {

		Thread thread = new Thread(() -> {
			System.out.println("started");
			try {
				Thread.sleep(4000);
				System.out.println("woke up");
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}
			System.out.println("stopped");
		});
		thread.start();
		
		Util.pause(2000);
		
		thread.interrupt();

	}

}
