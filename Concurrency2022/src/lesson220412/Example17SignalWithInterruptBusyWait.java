package lesson220412;

import utils.Util;

public class Example17SignalWithInterruptBusyWait {

	public static void main(String[] args) {

		Thread thread = new Thread(() -> {
			System.out.println("started");
			while (!Thread.interrupted()) { // busy wait
				// empty
			}
			System.out.println("stopped");
		});
		thread.start();

		Util.pause(20000);

		thread.interrupt();

	}

}
