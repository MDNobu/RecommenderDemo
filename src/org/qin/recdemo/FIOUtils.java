package org.qin.recdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FIOUtils {

	public static final String SPLIT_REGEX = ",";
	
	public static void readFile(String fileName) throws IOException {
		File file = new File(fileName);
		readFile(file);
	}
	
	public static void readFile(File file) throws IOException {
		if(file.isDirectory()) {
			File[] childFiles = file.listFiles();
			for(File childFile : childFiles) {
				readFile(childFile);
			}
		}
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while(null != (line = br.readLine())) {
			handleLine(line);
		}
	}

	private static void handleLine(String line) {
		UserTable userTable = new UserTable();
		
		String[] terms = line.split(SPLIT_REGEX);
		UserRecord userRecord = new UserRecord(terms[0], terms[2], terms[3]);
	}
	
}
