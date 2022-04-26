package lesson220426;

import java.util.concurrent.SynchronousQueue;

import utils.Util;

public class Example30SynchQueue {
	
	public static void main(String[] args) {
		
		
		SynchronousQueue<String> sq = new SynchronousQueue<>();
		
		new Thread(()-> {
			String result;
			try {
				result = sq.take();
				System.out.println(result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		Util.pause(2000);
		try {
			sq.put("hello");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("finished");
		
	}

}
