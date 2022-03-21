package lesson220315;

public class Example02 {
	
	public static void main(String[] args) {
		
		Task task = new Task();
		
//		new Thread(task, "some name").start();
		new Thread(task, "some name").run();
		
	}

}


class Task implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
	}
	
}