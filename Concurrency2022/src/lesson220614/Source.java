package lesson220614;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import utils.Util;

class Source implements Runnable {

	private Executor service;

	public Source(Executor service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		long id = 0;
		while (true) {
			Util.pause(1000);
			service.execute(new Event(id++));
		}
		
	}
	
}