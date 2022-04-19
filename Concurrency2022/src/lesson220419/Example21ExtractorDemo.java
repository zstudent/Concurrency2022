package lesson220419;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import utils.Util;

public class Example21ExtractorDemo {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		BlockingQueue<Object> bq = new LinkedBlockingQueue<>();
		
		new Thread(new Extractor(bq, 1000)).start();
		
		Util.pause(10000);
		
		System.out.println(bq);
		
	}

}
