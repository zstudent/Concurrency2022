package lesson220315;

public class RowSumCalculator implements Runnable {

	private double[] r;
	private double[] data;
	private int row;

	public RowSumCalculator(int row, double[] r, double[] data) {
		this.row = row;
		this.r = r;
		this.data = data;
	}

	@Override
	public void run() {
		double d = data[0];
		for (int i = 1; i < data.length; i++) {
			d += data[i];
		}
		r[row] = d;
	}

}
