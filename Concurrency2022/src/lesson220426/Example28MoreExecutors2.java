package lesson220426;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import utils.Util;

public class Example28MoreExecutors2 {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		
		Random r = new Random();
		
		for (int i = 0; i < 100; i++) {
			pool.execute(()-> {
				Util.pause(1000 + r.nextInt(2000));
				System.out.println(Thread.currentThread());
			});
			Util.pause(100);
		}
	}

}
