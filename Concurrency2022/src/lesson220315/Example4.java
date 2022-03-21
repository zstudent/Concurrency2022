package lesson220315;

public class Example4 {
	
	public static void main(String[] args) {
		new MyThread2("my name").run();
	}

}

class MyThread2 extends Thread {
	
	public MyThread2(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread());
	}
}