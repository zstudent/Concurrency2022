package lesson220419;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import utils.Util;

public class Example22TransformerDemo {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		BlockingQueue<Object> input = new LinkedBlockingQueue<>();
		BlockingQueue<Object> output = new LinkedBlockingQueue<>();
		
		new Thread(new Extractor(input, 1000)).start();
		new Thread(new Transformer(input, output, 1000)).start();
		
		Util.pause(10000);
		
		System.out.println(input);
		System.out.println(output);
		
	}

}
