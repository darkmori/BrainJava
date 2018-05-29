package com.koseal.kmove30;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class JDBC_Manager {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public JDBC_Manager(Connection conn, Statement stmt, ResultSet rs) {
		super();
		this.conn = conn;
		this.stmt = stmt;
		this.rs = rs;
	}

	public JDBC_Manager() {
		System.out.println("JDBC_Manager 기본자 생성자 호출");
	}

	public Connection DBConnection(String driver, String url, String user, String pass) throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
		return conn;

	}

	public ResultSet SelectTable(String query) throws Exception {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		return rs;
	}

	public void DBClose() throws Exception {
		conn.close();
	}
}
