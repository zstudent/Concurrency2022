package lesson220614;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example49ProblemWithOrder {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		service.execute(new Source(service));
		
	}

}

