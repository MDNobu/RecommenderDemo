package org.qin.recdemo;

import java.util.HashMap;
import java.util.Map;

public class RecordTable extends HashMap<String, UserRecord>{
 
	private static RecordTable recordTable = new RecordTable();

	private RecordTable() {
		
	}
	
	public static RecordTable getRecordTable() {
		return recordTable;
	}
	
	public void printAll() {
		for(Map.Entry<String, UserRecord> entry : this.entrySet()) {
			entry.getValue().print();
		}
	}
}
