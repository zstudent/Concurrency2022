package lesson220614;

import java.util.Random;

import utils.Util;

class Event implements Runnable {
	
	static Random r = new Random();

	private long id;

	public Event(long l) {
		this.id = l;
	}

	@Override
	public void run() {
		Util.pause(500 + r.nextInt(5000));
		System.out.println(id + "  -->  " + Thread.currentThread());
	}
	
}