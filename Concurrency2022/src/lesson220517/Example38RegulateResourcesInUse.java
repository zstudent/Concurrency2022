package lesson220517;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Example38RegulateResourcesInUse {

	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(6);
		
		var sem = new Semaphore(10);
		
		while (true) {
			sem.acquireUninterruptibly(); // main thread
			es.execute(() -> {
				System.out.println(Thread.currentThread());
				sem.release();  // thread from pool
			});
		}
		
		
	}
	
}
