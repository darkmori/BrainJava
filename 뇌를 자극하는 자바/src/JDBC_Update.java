/**
 * 2018. 5. 8. Dev By Jeong.K.S
 * 
 * JDBC_Update.java
 */

//package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JDBC_Update {
	public static void main(String args[]) {
		// 1�ܰ�: DB������ ���� Ŀ�ؼ� �������̽�
		Connection conn = null;
		// Statement Interface - SQL ����.
		Statement stmt = null;
		// ResultSet Interface - SQL ����� ����
		ResultSet rs = null;
		// try~catch������ DB�����߿� ���ܰ� �߻��ϴ����� �˻�.
		try {
			String jumincd = null;
			String pname = null;
			String gender = null;
			int age = 0;
			// 2�ܰ� :JDBC����̹��� �ε��Ѵ�
			Class.forName("com.mysql.jdbc.Driver");
			// 3�ܰ�: ����̹��Ŵ��� Ŭ������ DB�� �����Ѵ�.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345");
			System.out.println("�����ͺ��̽��� �����߽��ϴ�.");

			// DB SQL�۾�
			stmt = conn.createStatement();
			String sql = "update person SET age=22 WHERE jumincd='7803101574311'";
			int changeRecord = stmt.executeUpdate(sql);

			// 4�ܰ�: DB������ �����Ѵ�.
			conn.close();
			System.out.println(changeRecord + "���� �����Ǿ����ϴ�.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}