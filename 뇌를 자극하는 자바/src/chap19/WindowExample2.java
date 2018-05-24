package chap19;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WindowExample2 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Hello Java Programm");
		frame.setPreferredSize(new Dimension(200, 250));
		// frame.setLocation(500, 400);
		ImageIcon image = new ImageIcon("images/001.png");
		JLabel imglabel = new JLabel(image);

		Container contentPane = frame.getContentPane();

		JTextField text = new JTextField();
		JTextField text2 = new JTextField();

		JPanel jPanel = new JPanel();
		jPanel.add(text);
		jPanel.add(text2);

		JButton button = new JButton("확인");
		JLabel label = new JLabel("Hello");

		contentPane.add(jPanel, BorderLayout.CENTER);
		// contentPane.add(text2, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);

		contentPane.add(imglabel, BorderLayout.NORTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}
