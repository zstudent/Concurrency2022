package lesson220503;

import java.util.concurrent.locks.ReentrantLock;

import utils.Util;

public class Example36DeadLockWithLocks {

	public static void main(String[] args) {

		var o1 = new ReentrantLock();
		var o2 = new ReentrantLock();

		new Thread(() -> {
			while (true) {
				o1.lock();
				Util.pause(10);
				boolean success = o2.tryLock();
				if (success) {
					System.out.println(Thread.currentThread());
					break;
				} else {
					o1.unlock();
				}
			}
		}).start();

		new Thread(() -> {
			o2.lock();
			try {
				Util.pause(10);
				o1.lock();
				try {
					System.out.println(Thread.currentThread());
				} finally {
					o1.unlock();
				}
			} finally {
				o2.unlock();
			}
		}).start();

	}

}
