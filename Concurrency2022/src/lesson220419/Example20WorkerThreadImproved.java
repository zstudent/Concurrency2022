package lesson220419;

public class Example20WorkerThreadImproved {

	public static void main(String[] args) {

		WorkerThread worker = new WorkerThread();
		for (int i = 0; i < 5; i++) {
			worker.execute(() -> {
				System.out.println("hi there from " + Thread.currentThread());
			});
		}

	}

}

class WorkerThread {

	private MyBlockingQueue<Runnable> tasks = new MyBlockingQueue<>();

	public WorkerThread() {
		new Thread(() -> {
			while (true) {
				Runnable task = tasks.take();
				try {
					task.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void execute(Runnable task) {
		tasks.put(task);
	}

}