package lesson220419;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<T> {
	
	private Queue<T> items = new LinkedList<>();
//	private Object mutex = new Object();
	
	public void put(T item) {
		synchronized (items) {
			items.offer(item);
			items.notifyAll();
		}
	}
	
	public T take() {
		synchronized (items) {
			while (items.isEmpty()) {
				try {
					items.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return items.poll();
		}
	}

}
