package lesson220426;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import utils.Util;

public class Example24Executors {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		executor.execute(()-> {
			System.out.println(Thread.currentThread());
			Util.pause(5000);
		});

		executor.execute(()-> {
			System.out.println(Thread.currentThread());
			Util.pause(5000);
		});
		
		executor.shutdown();
		
		try {
			boolean termination = executor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("finished");
		
//		Util.pause(3000);
//		executor.shutdownNow();
	}

}
