package lesson220419;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import utils.Util;

public class Loader implements Runnable {
	
	private BlockingQueue<Object> queue;
	private int time;

	public Loader(BlockingQueue<Object> queue, int time) {
		this.queue = queue;
		this.time = time;
	}

	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			Util.pause(time + r.nextLong(time));
			try {
				Object item = queue.take();
				System.out.println(item);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
