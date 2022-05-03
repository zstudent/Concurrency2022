package lesson220503;

import java.lang.Thread.State;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.Util;

public class Example33ThreadWaitingForALockWithTimeout {

	public static void main(String[] args) {
		System.out.println("start");

		Lock lock = new ReentrantLock();

		Thread thread = new Thread(() -> {
			System.out.println("thread started");
			try {
				boolean success = lock.tryLock(3, TimeUnit.SECONDS);
				System.out.println("lock is acquired = " + success);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		});

		lock.lock();
		try {
			thread.start();
			Util.pause(1000);
			// now if we check, the thread will remain blocked forever
			while (thread.getState() != State.TERMINATED) {
				Util.pause(1000);
				System.out.println(thread.getState());
			}
		} finally {
			lock.unlock();
		}

	}

}
