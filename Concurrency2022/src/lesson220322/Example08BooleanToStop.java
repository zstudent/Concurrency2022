package lesson220322;

public class Example08BooleanToStop {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("start");
		AdditionBenchmark3 task = new AdditionBenchmark3();
		Thread t = new Thread(task);
		t.start();
		Thread.sleep(1000);
		task.stop();
		t.join();
		System.out.println(task.getCounter());
		System.out.println("stop");
	}

}


class AdditionBenchmark3 implements Runnable {
	
	private long counter = 0;
	volatile private boolean stop = false;

	@Override
	public void run() {
		
		while (!stop) {
			counter = getCounter() + 1;
		}
		
	}

	public long getCounter() {
		return counter;
	}
	
	public void stop() {
		stop = true;
	}
	
}