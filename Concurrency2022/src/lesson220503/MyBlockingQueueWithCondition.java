package lesson220503;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueWithCondition<T> {
	
	private Queue<T> items = new LinkedList<>();
	private Lock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	
	public void put(T item) {
		lock.lock();
		try {
			items.offer(item);
			notEmpty.signal();
			
		} finally {
			lock.unlock();
		}
	}
	
	public T take() {
		lock.lock();
		try {
			while (items.isEmpty()) {
				notEmpty.awaitUninterruptibly();
			}
			return items.poll();
			
		} finally {
			lock.unlock();
		}
	}

}
