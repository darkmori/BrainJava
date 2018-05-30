package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.koseal.kmove30.JDBC_Manager;

public class AddActionListener implements ActionListener {

	JDBC_Manager jdbc_Manager;
	JTable table;
	JTextField text1, text2, text3;

	public AddActionListener(JDBC_Manager jdbc_Manager, JTable table, JTextField text1, JTextField text2,
			JTextField text3) {
		super();
		this.jdbc_Manager = jdbc_Manager;
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String arr[] = new String[3];
		arr[0] = text1.getText();
		arr[1] = text2.getText();
		arr[2] = text3.getText();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		boolean isCheck = false;

		Object name = table.getValueAt(0, 0);
		String addName = name.toString();
		System.out.println(addName);

		model.addRow(arr);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > 0)
				isCheck = true;
			else
				isCheck = false;
			System.out.println("arr[" + i + "]:" + arr[i]);
		}

		if (isCheck) {
			model.addRow(arr); // JTable에 데이터 추가
			// DB insert 추가 작업
			try {
				jdbc_Manager.insertTable(arr);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		text1.setText("");
		text2.setText("");
		text3.setText("");
	}

}
