package lesson220315;


import java.util.Arrays;
import java.util.stream.IntStream;

public class Example05Threaded {
	
	public static void main(String[] args) {
		
		System.out.println("Generating the data...");
		
		double[][] m = generate(10, 10_000_000);
		
		long start = System.currentTimeMillis();
		
		double d = process(m);
		
		long stop = System.currentTimeMillis();
		
		System.out.println(stop - start);
		System.out.println(d);
	}

	private static double process(double[][] m) {
		double[] res = new double[m.length];
		Thread[] t = new Thread[m.length];
		for (int i = 0; i < m.length; i++) {
			Runnable task = new RowSumCalculator(i, res, m[i]);
			t[i] = new Thread(task);
			t[i].start();
		}
		// TODO wait for threads will finish
		// ???
		
		double s = 0;
		for (int i = 0; i < res.length; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s += res[i];
		}
		return s;
	}


	private static double[][] generate(int rows, int size) {
		
		double[][] m = new double[rows][size];
		var threads = new Thread[rows];
		
		for (int i = 0; i < m.length; i++) {
			RowTask rowTask = RowTask.make(m, i);
			threads[i] = new Thread(rowTask);
			threads[i].start();
		}

		joinAllThreads(threads);

		return m;
	}

	private static void joinAllThreads(Thread[] threadArray) {
		Arrays.stream(threadArray).forEach(ThreadOps::join);
	}

	private static class ThreadOps {
		public static void join(Thread thread) {
			try {
				thread.join();
			} catch (InterruptedException ignored) {}
		}
	}

}


class RowTask implements Runnable {

	private final double[][] matrix;
	private final int rowIndex;
	private final int columnCount;

	private RowTask(double[][] matrix, int rowIndex) {
		this.matrix = matrix;
		this.rowIndex = rowIndex;
		this.columnCount = matrix[0].length;
	}

	public static RowTask make(double[][] matrix, int rowIndex) {
		return new RowTask(matrix, rowIndex);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + " started working");
		iterate(columnCount).forEach(this::fillRowWithRandomNumbers);
		System.out.println(Thread.currentThread() + " finished working");
	}

	private void fillRowWithRandomNumbers(int columnIndex) {
		matrix[rowIndex][columnIndex] = Math.random();
	}

	private IntStream iterateBetween(int start, int end) {
		return IntStream.range(start, end);
	}

	private IntStream iterate(int times) {
		return iterateBetween(0, times);
	}

}
