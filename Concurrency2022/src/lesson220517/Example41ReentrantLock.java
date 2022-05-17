package lesson220517;

import java.util.concurrent.locks.ReentrantLock;

import utils.Util;

public class Example41ReentrantLock {
	
	public static void main(String[] args) {
		
		
		var lock = new ReentrantLock();
		
		lock.lock();
		lock.lock();
		lock.lock();
		
		new Thread(() -> {
			System.out.println("trying to lock...");
			lock.lock();
			System.out.println("I've got it!");
		}).start();
		
		Util.pause(1000);
		
		lock.unlock();
		
		Util.pause(1000);
		System.out.println("try to lock again...");
		
		lock.lock();
		System.out.println("finish?..");
		System.out.println(lock.getHoldCount());
		
	}

}
