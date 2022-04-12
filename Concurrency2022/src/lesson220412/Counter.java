package lesson220412;

import utils.Util;

public class Counter {
	int c = 0;
	
	synchronized void inc() { // critical section
		// c++;
		int t = c;   // read
		t = t + 1;   // modify
		Util.pause(1);  
		c = t;        // write
	}
	
	public int get() {
		synchronized (this) {  // mutex  mutual exclusion,  monitor
			return c;
		}
	}
}