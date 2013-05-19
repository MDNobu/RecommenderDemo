package org.qin.recdemo;

import java.util.ArrayList;
import java.util.List;

public class UserRecord implements Distancable<UserRecord>{
	private static int id = 1;
	private static final String SPLIT_REGEX = "\\s+";
	
	private String rid = String.valueOf(id++);
	public String getRid() {
		return rid;
	}

	private String userName;
	private List<String> tags = new ArrayList<String>();
	private List<String> contents = new ArrayList<String>();
	private MyVect recordVect = new MyVect();
	
	public UserRecord(String userName, String tags, String contents) {
		this.userName = userName;
		this.tags.addAll(FIOUtils.getWordsFromPattern(tags, FIOUtils.WORD_PATTERN));
		this.contents.addAll(FIOUtils.getWordsFromPattern(contents, FIOUtils.WORD_PATTERN));
		trainRecordVect();
	}

	public void trainRecordVect() {
		for(String tag : tags) {
			recordVect.set(Dictionary.getDict().getWordIndex(tag), 5.0);
		}
		for(String word : contents) {
			recordVect.print();
			int index = Dictionary.getDict().getWordIndex(word);
			double value = recordVect.get(index) + 0.5d;
			recordVect.set(index, value);
		}
	}
	
	
	public MyVect getRecordVect() {
		return recordVect;
	}

	public void print() {
		
		System.out.print("user id:"+ rid + " ");
		System.out.print("user name:" + userName + " ");
		System.out.print("tags :");
		for(String tag : tags) {
			System.out.print(tag + " ");
		}
		System.out.println();
		System.out.print("contents :");
		for(String word : contents) {
			System.out.print(word + " ");
		}	
		System.out.println();
		
		System.out.print("record vector :");
		recordVect.print();
		System.out.println();
	}

	@Override
	public double getDistance(UserRecord other) {
		recordVect.getDistance(other.recordVect);
		return 0;
	}

	

}
