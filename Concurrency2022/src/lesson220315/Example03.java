package lesson220315;

public class Example03 {
	
	public static void main(String[] args) {
		new MyThread("my name").start();
	}

}

class MyThread extends Thread {
	
	public MyThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread());
	}
}