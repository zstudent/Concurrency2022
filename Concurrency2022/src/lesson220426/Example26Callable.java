package lesson220426;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utils.Util;

public class Example26Callable {
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Future<String> future1 = executor.submit(new Callable<String>() { // anonymous class

			@Override
			public String call() throws Exception {
				Util.pause(10000);
				return "hello";
			}
			
		});
		
		
//		while (!future1.isDone()) {
//			System.out.println("not ready yet");
//			Util.pause(1000);
//		}
		
		try {
			System.out.println(future1.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		
//		Future<String> future2 = executor.submit(() -> "world");
		
	}

}
