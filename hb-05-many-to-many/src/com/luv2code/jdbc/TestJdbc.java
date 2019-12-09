package com.luv2code.jdbc;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn = (Connection) DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connecting succesful!!");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
