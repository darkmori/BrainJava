package com.jeong.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CancleListener implements ActionListener {

	JTextField id;
	JPasswordField pw;

	public CancleListener(JTextField id, JPasswordField pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
