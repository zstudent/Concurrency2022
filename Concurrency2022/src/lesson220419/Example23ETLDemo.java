package lesson220419;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import utils.Util;

public class Example23ETLDemo {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		BlockingQueue<Object> input = new LinkedBlockingQueue<>(100);
		BlockingQueue<Object> output = new LinkedBlockingQueue<>();
		
		new Thread(new Extractor(input, 10)).start();
		new Thread(new Transformer(input, output, 1000)).start();
		new Thread(new Loader(output, 1000)).start();
		
		while (true) {
			Util.pause(1000);
			System.out.println(input.size() + " " + output.size());
		}
		
	}

}
