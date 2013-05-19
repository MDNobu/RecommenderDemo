package org.qin.recdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FIOUtils {
	public static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z]+");
	public static final String SPLIT_REGEX = "\t";
	
	public static void initAll(String fileName) {
		buildDictionary(fileName);
		Dictionary.getDict().initIndexMap();
		
		buildRecordTable(fileName);
		Dictionary.getDict().print();
		RecordTable.getRecordTable().printAll();
		User.trainUserTable();
		User.printAllUser();
	}

	private static void buildRecordTable(String fileName) {
		File file = new File(fileName);
		if(file.isDirectory()) {
			File[] childFiles = file.listFiles();
			for(File childFile : childFiles) {
				addSingleFileToRecordTable(childFile);
			}
		}
		
	}
	

	private static void addSingleFileToRecordTable(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			br.readLine();
			while(null != (line = br.readLine())) {
				String[] terms = line.split(SPLIT_REGEX);
				String userName = terms[0];
				String tags = terms[2];
				String contents = terms[3];
				UserRecord userRecord = new UserRecord(userName, tags, contents);
				if(User.userTable.get(userName) == null) {
					User newUser = new User(userName, userRecord);
				} else {
					User.userTable.get(userName).addRecord(userRecord);
				}
				RecordTable.getRecordTable().put(userRecord.getRid(), userRecord);				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void addSingleFileToDict(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			br.readLine();
			while(null != (line = br.readLine())) {
				String[] terms = line.split(SPLIT_REGEX);
				String tags = terms[2];
				String contents = terms[3];
				Dictionary.getDict().addKeyWords(tags + " " + contents);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void buildDictionary(String fileName) {
		File file = new File(fileName);
		if(file.isDirectory()) {
			File[] childFiles = file.listFiles();
			for(File childFile : childFiles) {
				addSingleFileToDict(childFile);
			}
		}
	}
	
	public static List<String> getWordsFromPattern(String line, Pattern p) {
		List<String> words = new ArrayList<String>();
		Matcher matcher = p.matcher(line);
		while(matcher.find()) {
			words.add(matcher.group());
		}		
		return words;
	}
}
