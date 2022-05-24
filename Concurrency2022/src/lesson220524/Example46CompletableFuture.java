package lesson220524;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import utils.Util;

public class Example46CompletableFuture {
	
	public static void main(String[] args) {
		
		CompletableFuture<String> cf = new CompletableFuture<>();
		
		new Thread(() -> {
			Util.pause(1000);
			cf.complete(Thread.currentThread().toString());
		}).start();
		
		Util.pause(1000);
		
		try {
			String result = cf.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}