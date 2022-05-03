package lesson220503;

import utils.Util;

public class Example35DeadLockWithSynchronized {
	
	public static void main(String[] args) {
		
		var o1 = new Object();
		var o2 = new Object();
		
		new Thread(() -> {
			synchronized (o1) {
				Util.pause(10);
				synchronized (o2) {
					System.out.println(Thread.currentThread());
				}
			}
		}).start();
		
		new Thread(() -> {
			synchronized (o2) {
				Util.pause(10);
				synchronized (o1) {
					System.out.println(Thread.currentThread());
				}
			}
		}).start();
		
		
	}

}
