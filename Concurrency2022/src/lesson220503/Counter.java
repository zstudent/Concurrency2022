package lesson220503;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.Util;

public class Counter {
	int c = 0;
	Lock lock = new ReentrantLock();

	void inc() {
		lock.lock(); // entrance to the critical section
		try {
			// c++;
			int t = c; // read
			t = t + 1; // modify
			Util.pause(1);
			c = t; // write
		} finally {
			lock.unlock(); // end of the critical section
		}
	}

	public int get() {
		lock.lock();
		try {
			return c;
		} finally {
			lock.unlock();
		}
	}
}