package org.qin.recdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.qin.test.Printable;
import org.qin.test.TestUtils;

public class User implements Printable{

	static Map<String, User> userTable = new HashMap<String, User>();
	public User(String userName, UserRecord userRecord) {
		this.userName = userName;
		userRecords.add(userRecord);
		userTable.put(userName, this);
	}

	private String userName = null;
	private MyVect userVec = new MyVect();
	private List<UserRecord> userRecords = new ArrayList<UserRecord>();
	private Distancable<User> userDist = new Distancable<User>() {
		@Override
		public double getDistance(User other) {
			return userVec.getDistance(other.userVec);
		}
	};
	private Distancable<UserRecord> recDist = new Distancable<UserRecord>() {
		@Override
		public double getDistance(UserRecord other) {
			return userVec.getDistance(other.getRecordVect());
		}
	};
	

	public List<UserRecord> getTopKInterestRecords(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getUserDistance(User other) {
		return userDist.getDistance(other);
	}
	
	public double getRecordDistance(UserRecord userRecord) {
		return recDist.getDistance(userRecord);
	}
	
	public void addRecord(UserRecord r) {
		userRecords.add(r);
	}
	
	public static void trainUserTable() {
		for(User user :userTable.values()) {
			for(UserRecord record : user.userRecords) {
				user.userVec.add(record.getRecordVect());
			}
		}
	}

	public static void printAllUser() {
		TestUtils.printList(User.userTable.values());
	}
	
	public void print() {
		System.out.print("user name :");
		System.out.println(userName);
		System.out.print("user vector:");
		//System.out.println(userVec);
		userVec.print();
		//TestUtils.printList(userRecords);
		for(UserRecord record : userRecords) {
			System.out.print(record.getRid() + " ");
		}
		System.out.println();
	}
}
