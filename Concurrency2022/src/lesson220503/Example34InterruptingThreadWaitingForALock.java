package lesson220503;

import java.lang.Thread.State;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.Util;

public class Example34InterruptingThreadWaitingForALock {

	public static void main(String[] args) {
		System.out.println("start");

		Lock lock = new ReentrantLock();

		Thread thread = new Thread(() -> {
			System.out.println("thread started");
			try {
				lock.lockInterruptibly();
				System.out.println("lock is acquired");
			} catch (InterruptedException e) {
				System.out.println("interrupted!");
			} finally {
				lock.unlock();
			}
		});

		lock.lock();
		try {
			thread.start();
			Util.pause(3000);
			thread.interrupt();
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
