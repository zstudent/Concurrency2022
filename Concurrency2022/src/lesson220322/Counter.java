package lesson220322;

import utils.Util;

public class Counter {
	int c = 0;
	
	public void inc() {
		// c++;
		int t = c;   // read
		t = t + 1;   // modify
		Util.pause(1);  
		c = t;        // write
	}
	
	public int get() {
		return c;
	}
}