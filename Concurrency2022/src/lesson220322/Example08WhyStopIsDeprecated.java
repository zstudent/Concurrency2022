package lesson220322;

public class Example08WhyStopIsDeprecated {
	
	public static void main(String[] args) throws InterruptedException {
		Data data = new Data();
		Thread t = new Thread(new TaskWithInvariant(data));
		t.start();
		Thread.sleep(1000);
		t.stop();
		System.out.println(data.isValid());
	}

}


class TaskWithInvariant implements Runnable {
	
	private Data data;

	public TaskWithInvariant(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		while (true) {
			data.change();
		}
		
	}
	
}

class Data {
	int x;
	int y;
	
	void change() {
		x++;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		y--;
	}
	
	boolean isValid() {
		return x+y == 0;
	}
}