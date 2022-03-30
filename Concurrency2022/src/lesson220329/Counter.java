package lesson220329;

import utils.Util;

public class Counter {
	int c = 0;
	
	synchronized void inc() {
		// c++;
		int t = c;   // read
		t = t + 1;   // modify
		Util.pause(1);  
		c = t;        // write
	}
	
	synchronized public int get() {
		return c;
	}
}