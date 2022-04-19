package lesson220419;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import utils.Util;

public class Transformer implements Runnable {

	private BlockingQueue<Object> input;
	private BlockingQueue<Object> output;
	private int time;

	public Transformer(BlockingQueue<Object> input, BlockingQueue<Object> output, int time) {
		this.input = input;
		this.output = output;
		this.time = time;
	}

	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			try {
				Object item = input.take();
				Util.pause(time + r.nextLong(time)); // process item
				output.put(item);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
