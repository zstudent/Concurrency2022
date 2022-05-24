package lesson220524;

import java.util.concurrent.Callable;

import utils.Util;

public class LongIOTask implements Callable<String> {  // I/O - input/output

	@Override
	public String call() throws Exception {
		Util.pause(1000);  // imitation of I/O operation wait
		return "Hello from " + Thread.currentThread();
	}

}
