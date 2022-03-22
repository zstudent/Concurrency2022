package lesson220322;

public class Example07 {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("start");
		AdditionBenchmark2 task = new AdditionBenchmark2();
		Thread t = new Thread(task);
		t.start();
		Thread.sleep(1000);
		t.stop();
		t.join();
		System.out.println(task.getCounter());
		System.out.println("stop");
	}

}


class AdditionBenchmark2 implements Runnable {
	
	private long counter = 0;

	@Override
	public void run() {
		
		while (true) {
			counter = getCounter() + 1;
		}
		
	}

	public long getCounter() {
		return counter;
	}
	
}