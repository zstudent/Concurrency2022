package lesson220322;

import utils.Util;

class Counter {
	int c = 0;
	
	public void inc() {
		int t = c;
		t = t + 1;
		Util.pause(1);
		c = t;
	}
	
	public int get() {
		return c;
	}
}