package lesson220315;


public class Example05 {
	
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
		double s = 0;
		for (int i = 0; i < m.length; i++) {
			s += calc(m[i]);
		}
		return s;
	}

	private static double calc(double[] ds) {
		double r = ds[0];
		for (int i = 1; i < ds.length; i++) {
			r += ds[i];
		}
		return r;
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
