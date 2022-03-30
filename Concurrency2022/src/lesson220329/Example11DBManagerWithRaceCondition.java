package lesson220329;

import utils.Util;

public class Example11DBManagerWithRaceCondition {
	
	public static void main(String[] args) {
		new Thread(() -> {
			UseDBManager1 useDBManager1 = new UseDBManager1();
			Util.pause(1000);
			System.out.println("Use1 (2)" + useDBManager1.dbManager);
		}).start();
		
		new Thread(() -> {
			var dbm  = new UseDBManager2();
			dbm.dataProcessing();
			Util.pause(1000);
			dbm.dataProcessing();
		}).start();
	}

}
