package lesson220503;

import utils.Util;

public class Example31RaceConditionFixedWithLock {
	
	public static void main(String[] args) {
		
		Counter cnt = new Counter();
		new Thread(new CounterTask(cnt)).start();
		new Thread(new CounterTask(cnt)).start();

		int i = 0;
		while (true) {
			Util.pause(1000);
			System.out.println(i++ + " " + cnt.get());
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
