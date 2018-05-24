package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

class ConfirmButtonActionListener implements ActionListener {
	JTextField text;
	JLabel label;

	ConfirmButtonActionListener(JTextField text, JLabel label) {
		super();
		this.text = text;
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = text.getText();
		label.setText("Hello, " + name);
	}

}
