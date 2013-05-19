package org.qin.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Integer a = 5;
		Integer b = 10;
		
		System.out.println("a=" + a+ ", b =" + b);
		swap(a,b);
		System.out.println("a=" + a+ ", b =" + b);
	}
	
	public static void swap(Integer a, Integer b) {
		Integer tmp = b;
		a = tmp;
		b = a;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		String connUrl = "jdbc:mysql://localhost/cookbook";
		String userName = "cbuser";
		String password = "111111";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(connUrl,userName, password);
			System.out.println("conntected");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("contected failed");
		} 
		return conn;
	}

	public static void query() throws SQLException {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		state.executeQuery("select * from limbs");
		ResultSet rs = state.getResultSet();
		int count = 0;
		
		while(rs.next()) {
			int id = rs.getInt(1);
			//String name = rs.getString(2);
			//long cats = rs.getLong(5);
			//System.out.println("id:" + id +", name:" + name + ", cats:" + cats);
			System.out.println("id:" + id);
			count++;
		}
		rs.close();
		state.close();
		System.out.println("system rows count" +  count);
	}
	
}
