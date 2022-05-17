package lesson220517;

public class Example40ReentrancyWithSynchronized {

	static int deep = 100;

	public static void main(String[] args) {

		var mutex = new Object();

		m2(mutex);

	}

	private static void m2(Object mutex) {
		synchronized (mutex) {
			System.out.println(deep);
			deep--;
			if (deep == 0)
				return;
			m(mutex);
		}
	}

	private static void m(Object mutex) {
		synchronized (mutex) {
			System.err.println(deep);
			deep--;
			if (deep == 0)
				return;
			m2(mutex);
		}
	}

}
