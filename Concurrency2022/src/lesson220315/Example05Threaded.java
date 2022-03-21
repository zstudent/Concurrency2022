package lesson220315;


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
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = Math.random();
			}
		}
		
		return m;
	}

}
