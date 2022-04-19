package lesson220412;

import java.util.LinkedList;
import java.util.Queue;

public class Example19WorkerThreadWaitNotify {

	public static void main(String[] args) {

		WorkerThread2 worker = new WorkerThread2();
		for (int i = 0; i < 5; i++) {
			worker.execute(() -> {
				System.out.println("hi there from " + Thread.currentThread());
			});
		}

	}

}

class WorkerThread2 {

	private Queue<Runnable> tasks = new LinkedList<>();

	public WorkerThread2() {
		new Thread(() -> {
			while (true) {
				Runnable task = null;
				while (task == null) {
					synchronized (tasks) {  // acquire the mutex
						task = tasks.poll();
						if (task == null) {
							try {
								tasks.wait(); // waiting for a signal, mutex is freed
								// after receiving the signal we wait for mutex to be acquired
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							continue;
						}
					}
					try {
						task.run();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					task = null;
				}
			}
		}).start();
	}

	public void execute(Runnable task) {
		synchronized (tasks) { // tasks here is a mutex (monitor)
			tasks.offer(task);
			tasks.notify();
			System.out.println(tasks.size());
		}
	}

}