package lesson220412;

import utils.Util;

public class Example14 {
	
	synchronized static void doit() {
		System.out.println("got it!" + Thread.currentThread());
	}
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			
			doit();
			
		}).start();
		
		synchronized (Example14.class) {
			System.out.println("got it! " + Thread.currentThread());
			Util.pause(3000);
			System.out.println("released it! " + Thread.currentThread());
		}
		
	}

}
