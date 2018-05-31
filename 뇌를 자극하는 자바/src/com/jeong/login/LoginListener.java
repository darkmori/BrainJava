package com.jeong.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginListener implements ActionListener {

	SQLManager sqlManager = new SQLManager();

	JTextField id;
	JPasswordField pw;

	public LoginListener(SQLManager sqlManager, JTextField id, JPasswordField pw) {
		super();
		this.sqlManager = sqlManager;
		this.id = id;
		this.pw = pw;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
