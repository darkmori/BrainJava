package com.jeong.login;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI {

	public static void main(String[] args) {
		SQLManager sqlManager=new SQLManager();
		JFrame jFrame = new JFrame("로그인");
		jFrame.setPreferredSize(new Dimension(220, 130));
		jFrame.setLocation(500, 400);
		JPanel panel = new JPanel();

		Container contentPane = jFrame.getContentPane();

		JTextField id = new JTextField(15);
		JPasswordField pw = new JPasswordField(14);
		JButton login = new JButton("login");
		JButton cancle = new JButton("cancle");

		panel.add(new JLabel("ID:"));
		panel.add(id);
		panel.add(new JLabel("PW:"));
		panel.add(pw);

		panel.add(login);
		panel.add(cancle);
		contentPane.add(panel, BorderLayout.CENTER);

		login.addActionListener(new LoginListener(id, pw));
		cancle.addActionListener(new CancleListener(sqlManager, id, pw));

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);

	}

}
