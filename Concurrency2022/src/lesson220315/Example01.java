package lesson220315;

public class Example01 {
	
	public static void main(String[] args) throws InterruptedException {  // entry point
		System.out.println(Thread.currentThread());
		
		new Thread(() -> {
			System.out.println(Thread.currentThread());
		}).start();
		
//		Thread.sleep(10);
		
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
