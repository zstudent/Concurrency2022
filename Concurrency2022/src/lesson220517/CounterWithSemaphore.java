package lesson220517;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.Util;

public class CounterWithSemaphore {
	int c = 0;
	
	Semaphore sem = new Semaphore(1, true);  // fair: waiting threads will be queued

	void inc() {
		sem.acquireUninterruptibly(); // entrance to the critical section
		try {
			// c++;
			int t = c; // read
			t = t + 1; // modify
			Util.pause(1);
			c = t; // write
		} finally {
			sem.release(); // end of the critical section
		}
	}

	public int get() {
		sem.acquireUninterruptibly();
		try {
			return c;
		} finally {
			sem.release();
		}
	}
}