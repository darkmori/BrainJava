package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.koseal.kmove30JD.JDBC_Manager;

public class SelectActionListener implements ActionListener {

	// 속성
	JTable table;
	JDBC_Manager jdbc_Manager;
	ResultSet rs;

	// 생성자
	SelectActionListener(JDBC_Manager jdbc_Manager, JTable table) {
		super();
		this.jdbc_Manager = jdbc_Manager;
		this.table = table;
	}

	// 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String query = "select pname, age, gender from person";
		String arr[] = new String[3];
		// arr[0] = text1.getText();
		// arr[1] = text2.getText();
		// arr[2] = text3.getText();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
			rs = jdbc_Manager.SelectTable(query);

			while (rs.next()) {
				arr[0] = rs.getString("pname");
				arr[1] = rs.getString("age");
				arr[2] = rs.getString("gender");
			}
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

}
