package lesson220412;

import java.util.LinkedList;
import java.util.Queue;

public class Example19WorkerThreadBusyWait {

	public static void main(String[] args) {

		WorkerThread1 worker = new WorkerThread1();
		for (int i = 0; i < 5; i++) {
			worker.execute(() -> {
				System.out.println("hi there from " + Thread.currentThread());
			});
		}

	}

}

class WorkerThread1 {
	
	Queue<Runnable> tasks = new LinkedList<>();
	
	public WorkerThread1() {
		new Thread(() -> {
			while (true) { // busy wait
				Runnable task = tasks.poll();
				if (task == null) 
					continue;
				try {
					task.run();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}).start();
	}

	public void execute(Runnable task) {
		tasks.offer(task);
		System.out.println(tasks.size());
	}

}