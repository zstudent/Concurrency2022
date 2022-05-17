package lesson220517;

import java.util.concurrent.locks.ReentrantLock;

import utils.Util;

public class Example43ReleaseLockInAnotherThread {

	public static void main(String[] args) {

		var lock = new ReentrantLock();

		lock.lock();

		new Thread(() -> {
			System.out.println("unlocking");
			lock.unlock();
		}).start();
		
		Util.pause(1000);
		
		System.out.println("finish?.");
	}

}
