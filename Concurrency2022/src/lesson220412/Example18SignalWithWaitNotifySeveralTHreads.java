package lesson220412;

import utils.Util;

public class Example18SignalWithWaitNotifySeveralTHreads {

	public static void main(String[] args) {
		
		Object mutex = new Object();

		new Thread(() -> {
			System.out.println("started");
			synchronized (mutex) {
				try {
					mutex.wait();
					System.out.println("got signal");
				} catch (InterruptedException e) {
					System.out.println("interrupted");
				}
			}
			System.out.println("stopped");
		}).start();
		
		new Thread(() -> {
			System.out.println("started");
			synchronized (mutex) {
				try {
					mutex.wait();
					System.out.println("got signal");
				} catch (InterruptedException e) {
					System.out.println("interrupted");
				}
			}
			System.out.println("stopped");
		}).start();
		
		new Thread(() -> {
			System.out.println("started");
			synchronized (mutex) {
				try {
					mutex.wait();
					System.out.println("got signal");
				} catch (InterruptedException e) {
					System.out.println("interrupted");
				}
			}
			System.out.println("stopped");
		}).start();
		
		Util.pause(10000);
		
//		thread.interrupt();
		
//		mutex.notify();  // Exception! 
		
		synchronized (mutex) {
			System.out.println("got mutex");
			Util.pause(10000);
			System.out.println("sent signal");
//			mutex.notify();
//			mutex.notify();
//			mutex.notify();
			mutex.notifyAll();
			Util.pause(15000);
			System.out.println("release mutex");
		}

	}

}
