package lesson220524;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utils.Util;

public class Example45 {
	
	public static void main(String[] args) {
		
		var es = Executors.newFixedThreadPool(2);
		
		Future<String> future = es.submit(new LongCalculationTask());
		
		System.out.println("submitted");
		
		Util.pause(2000);
		
		System.out.println("waiting...");
		try {
			String result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		es.shutdown();
		
	}

}


class LongCalculationTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		Util.pause(5000);
		return Thread.currentThread().toString();
	}
	
}