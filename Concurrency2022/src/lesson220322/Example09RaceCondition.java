package lesson220322;

import utils.Util;

public class Example09RaceCondition {
	
	public static void main(String[] args) {
		
		Counter cnt = new Counter();
		new Thread(new CounterTask(cnt)).start();
		new Thread(new CounterTask(cnt)).start();

		while (true) {
			System.out.println(cnt.get());
			Util.pause(1000);
		}
	}

}


class CounterTask implements Runnable {
	
	private Counter cnt;

	public CounterTask(Counter cnt) {
		this.cnt = cnt;
	}

	@Override
	public void run() {
		while (true) {
			Util.pause(1000);
			cnt.inc();
		}
	}
	
}
