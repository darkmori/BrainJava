import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JDBCExample0 {
	public static void main(String args[]) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345");
			System.out.println("�����ͺ��̽��� �����߽��ϴ�.");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select pname, address, phoneno from custinfo");
			System.out.println("�̸�====================�ּ�================��ȭ��ȣ");

			while (rs.next()) {
				String pname = rs.getString(1);
				String address = rs.getString(2);
				String phoneno = rs.getString(3);

				System.out.println(pname + "-" + address + "-" + phoneno);
			}
			conn.close();

		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã���� �����ϴ�." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}