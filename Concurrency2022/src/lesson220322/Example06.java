package lesson220322;

public class Example06 {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("start");
		AdditionBenchmark task = new AdditionBenchmark();
		Thread t = new Thread(task);
		t.start();
		Thread.sleep(1000);
		t.interrupt();
		t.join();
		System.out.println(task.getCounter());
		System.out.println("stop");
	}

}


class AdditionBenchmark implements Runnable {
	
	private long counter = 0;

	@Override
	public void run() {
		
		while (!Thread.interrupted()) {
			counter = getCounter() + 1;
		}
		
	}

	public long getCounter() {
		return counter;
	}
	
}