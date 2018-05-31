package com.jeong.login;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SQLManager {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public SQLManager(Connection conn, Statement stmt, ResultSet rs) {
		super();
		this.conn = conn;
		this.stmt = stmt;
		this.rs = rs;
	}

	public SQLManager() {
		System.out.println("SQLManager()기본생성자 호출");
	}

	public void loginTable(String query) {
		System.out.println(query);
	}

}
