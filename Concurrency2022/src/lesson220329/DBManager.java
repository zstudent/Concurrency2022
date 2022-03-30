package lesson220329;


// Singleton
public class DBManager {
	private static DBManager instance = new DBManager();  // lazy!
//	volatile private static DBManager instance;
	
	static {
		System.out.println("static init");
	}
	
	public static DBManager get() { return instance; }
	
//	synchronized static DBManager get() {
//		if (instance == null) {  // lazy instantiation
//			instance = new DBManager();
//		}
//		return instance;
//	}
	
	private DBManager() {}
	
	{ // instance initializer
		System.out.println("init DBManager " + this);
	}
	
}
