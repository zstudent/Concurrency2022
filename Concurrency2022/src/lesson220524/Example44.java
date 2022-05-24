package lesson220524;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example44 {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(12);
		
		ExecutorCompletionService<String> cs = new ExecutorCompletionService<>(service); 
		
		for (int i = 0; i < 10; i++) {
			cs.submit(new LongIOTask());
		}
		
		for (int i = 0; i < 10; i++) {
			cs.submit(new CalculationTask());
		}
		
		for (int i = 0; i < 20; i++) {
			try {
				String result = cs.take().get();
				System.out.println(result);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
