package lesson220614;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example50FixProblemWithOrder {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		SerialExecutor serialExecutor = new SerialExecutor(service);

		Source source = new Source(serialExecutor);

		source.run();

	}

}

class SerialExecutor implements Executor {
	final Queue<Runnable> tasks = new ArrayDeque<>();
	final Executor executor;
	Runnable active;

	SerialExecutor(Executor executor) {
		this.executor = executor;
	}

	public synchronized void execute(Runnable r) {
		tasks.add(() -> {
			try {
				r.run();
			} finally {
				scheduleNext();
			}
		});
		if (active == null) {
			scheduleNext();
		}
	}

	protected synchronized void scheduleNext() {
		if ((active = tasks.poll()) != null) {
			executor.execute(active);
		}
	}
}