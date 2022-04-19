package lesson220419;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import utils.Util;

public class Extractor implements Runnable {
	
	private BlockingQueue<Object> queue;
	private int time;

	public Extractor(BlockingQueue<Object> queue, int time) {
		this.queue = queue;
		this.time = time;
	}

	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			Util.pause(time + r.nextLong(time));
			try {
				queue.put(new Object());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
