package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RemoveActionListener implements ActionListener {

	JTable table;

	RemoveActionListener(JTable table) {
		super();
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (row == -1)
			return;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(row);

		// 삭제될 이름
		Object name = table.getValueAt(row, 0);
		String deleteName = name.toString();
		System.out.println(deleteName);

		model.removeRow(row); // 선택된 행을 삭제
	}

}
