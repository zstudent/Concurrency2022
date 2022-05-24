package lesson220524;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import utils.Util;

public class Example47CompletableFuture2 {
	
	public static void main(String[] args) {
		
		var es = Executors.newSingleThreadExecutor();
		
		CompletableFuture
			.supplyAsync(() -> {
				Util.pause(1000);
				return Thread.currentThread().toString();
			}, es)
			.thenAccept(System.out::println);
	
		es.shutdown();
	}
	
	
	/*
	 * 
	 *    work1
	 *    work2
	 *    work3
	 * 
	 * 	  supplyAsync(work1).thenAccept(work3);
	 * 	  work2
	 * 
	 * 
	 */

}