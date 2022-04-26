package lesson220426;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import utils.Util;

public class Example29ScheduledThreadPool {
	
	public static void main(String[] args) {
		
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		
		pool.schedule(() -> {
			System.out.println(Thread.currentThread());
		}, 3, TimeUnit.SECONDS);
		
		ScheduledFuture<?> future = pool.scheduleAtFixedRate(()-> {
			System.out.println("hi there");
		}, 1, 1, TimeUnit.SECONDS);
		
		Util.pause(10000);
		
		future.cancel(true);
		
		pool.scheduleWithFixedDelay(()-> {
			System.out.println("hey");
			Util.pause(3000);
			System.out.println("there?");
		}, 1, 1, TimeUnit.SECONDS);
		
	}

}
