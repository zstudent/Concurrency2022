package lesson220524;

import java.util.concurrent.Callable;

import utils.Util;

public class CalculationTask implements Callable<String> {  

	@Override
	public String call() throws Exception {
		Util.pause(100);  // imitation of I/O operation wait
		return "Calculated by " + Thread.currentThread();
	}

}
