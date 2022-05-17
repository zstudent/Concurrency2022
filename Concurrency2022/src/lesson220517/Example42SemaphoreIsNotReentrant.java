package lesson220517;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import utils.Util;

public class Example42SemaphoreIsNotReentrant {
	
	public static void main(String[] args) {
		
		
		var sem = new Semaphore(2);
		
		sem.acquireUninterruptibly();
		sem.acquireUninterruptibly();
		sem.acquireUninterruptibly();

		System.out.println("finish?..");
	}

}
