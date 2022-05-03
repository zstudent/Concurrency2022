package lesson220503;

import java.lang.Thread.State;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.Util;

public class Example32StoppingThreadWaitingForAMutex {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		Lock lock = new ReentrantLock();
		
		Thread thread = new Thread(() -> {
			System.out.println("thread started");
			lock.lock();
			System.out.println("lock is acquired");
			try {
				System.out.println("thread start");
			} finally {
				lock.unlock();
			}
		});
		
		lock.lock();
		try {
			thread.start();
			Util.pause(1000);
			thread.stop();
			// now if we check, the thread will remain blocked forever
			while(thread.getState() != State.TERMINATED) {
				Util.pause(1000); 
				System.out.println(thread.getState());
			}
		} finally {
			lock.unlock();
		}
		
	}

}
