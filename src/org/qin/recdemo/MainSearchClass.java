package org.qin.recdemo;

import java.util.List;

public class MainSearchClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if( !"-f".equalsIgnoreCase(args[0])) {
			printUsage();
		}
		
		int i = 1;
		for(; i < args.length && !args[i].equalsIgnoreCase("-u"); i++) {
			FIOUtils.readFile(args[i]);
		}
		
		if(i >= args.length - 1) {
			printUsage();
			return;
		}
		
		for(;i <args.length; i++) {
			User user = UserTable.getUser(args[i]);
			List<UserRecord> topKInterestRecords = user.getTopKInterestRecords(5);
			for(UserRecord record : topKInterestRecords) {
				record.print();
			}
		}
		
	}
	
	public static void printUsage() {
		System.out.println("-f file/dir [file1/dir1[file2/dir2] ...]");
		System.out.println("-u user [user1[user2[user3]..]]");
		System.out.println("file/dir means the file or dir contents the user data");
		System.out.println("user means the user name you want to search");
	}

}
