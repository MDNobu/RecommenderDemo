package org.qin.recdemo;

import java.io.IOException;
import java.util.List;

public class MainSearchClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		if( !"-f".equalsIgnoreCase(args[0])) {
			printUsage();
		}
		
		FIOUtils.initAll(args[1]);
		
	}
	
	public static void printUsage() {
		System.out.println("-f file/dir [file1/dir1[file2/dir2] ...]");
		System.out.println("-u user [user1[user2[user3]..]]");
		System.out.println("file/dir means the file or dir contents the user data");
		System.out.println("user means the user name you want to search");
	}

}
