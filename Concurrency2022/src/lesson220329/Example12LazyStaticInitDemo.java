package lesson220329;

import utils.Util;

public class Example12LazyStaticInitDemo {
	
	public static void main(String[] args) {
		System.out.println("start");
		Demo demo;
		Util.pause(1000);
		System.out.println(Demo.CONST);
		Util.pause(1000);
		System.out.println(Demo.VAR);
		Util.pause(1000);
		System.out.println(Demo.get());
		System.out.println("finish");
	}

}


class Demo {
	
	public static final int CONST = 10;
	public static int VAR = 20;
	
	static Demo demo = new Demo();
	
	{
		System.out.println("init");
	}
	
	public static Demo get() { return demo; }
}