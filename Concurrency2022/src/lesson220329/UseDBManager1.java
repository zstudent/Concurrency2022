package lesson220329;

public class UseDBManager1 {
	
	DBManager dbManager;

	public UseDBManager1() {
		dbManager = DBManager.get();
		System.out.println("Use1 " + dbManager);
	}

}
