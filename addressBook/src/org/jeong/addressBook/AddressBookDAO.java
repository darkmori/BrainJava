package org.jeong.addressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddressBookDAO {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid = "scott";
	private String password = "tiger";

	private Connection con;

	// 생성자
	public AddressBookDAO() {
		// 드라이버 로딩과 connect객체를 만듬
		getConnection();
	}

	// getConnection()멤버 메서드
	Connection getConnection() {
		// 오라클드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Connection 객체를 만듬
		try {
			con = DriverManager.getConnection(url, userid, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("오라클드라이버 로딩 및 접속 성공");
		return con;
	}

	int saveDB(AddressBookDTO dto) {
		// DB에서 사용하는 sql문을 문자열로 지정
		int result = 0;
		String sql = "INSERT INTO ADDRESSBOOK(name,address,phone,email)" + "VALUES(?,?,?,?)";
		// sql문 실행을 위한 PreparedStatement객체 생성
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// insert할 값을 넣어줌 db의 데이터형이 varchar2는 String으로 처

			ps.setString(1, dto.getName());
			ps.setString(2, dto.getAddress());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getEmail());

			// ?값의 결정이 끝났으므로 preparedStatement실행
			// Insert는 excuteUpate를 사용
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	ArrayList<AddressBookDTO> searchDB(String name, String phone) {
		ArrayList<AddressBookDTO> arr = new ArrayList<AddressBookDTO>();
		// ArratList클래스는 List계열 Collection으로 동일한 데이터형의 값을 배열
		// 형태로 저장(배열보다 다양한 메서드를 제공)
		// < >는 generic을 표시하는 부호로 type parameter라고하며 ArrayList객체에
		// 저장되는 데이터형을 정의
		// SELECT결과의 레코드들을 가지는 객체 지정
		ResultSet rs = null;
		if ((name == null || name.equals("")) && (phone == null || phone.equals(""))) {
			String sql = "SELECT * FROM ADDRESSBOOK ORDER BY NAME ASC";
			try {
				// sql처리 객체 생성
				Statement st = con.createStatement();
				// sql실행 결과를 ResultSet에 지정
				rs = st.executeQuery(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (!(name == null || name.equals(""))) {
			String sql = "SELECT * FROM ADDRESSBOOK WHERE NAME=?";
			try {
				// PreparedStatement객체 생성
				PreparedStatement ps = con.prepareStatement(sql);
				// sql의 ?에 해당하는 name값을 넣어 줌
				ps.setString(1, name);
				// ResultSet값 저장
				rs = ps.executeQuery();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (!(phone == null || phone.equals(""))) {
			String sql = "SELECT * FROM ADDRESSBOOK WHERE PHONE=?";
			try {
				// PreparedStatement객체 생성
				PreparedStatement ps = con.prepareStatement(sql);
				// sql의 ?에 해당하는 name값을 넣어 줌
				ps.setString(1, phone);
				// ResultSet값 저장
				rs = ps.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// ResultSet에 저장된 레코드의 값을 dto객체로 변환하여ArrayList객체에 저장
		try {
			while (rs.next()) {
				// ResultSet클래스의 getString("db의 컬럼이름")은 레코드의
				// 컬럼값을 반환 만일 DB컬럼의 데이터형이 숫자이며 getInt()메서드를 사용
				String dname = rs.getString("name");
				String daddress = rs.getString("address");
				String dphone = rs.getString("phone");
				String demail = rs.getString("email");
				// AddressBookDTO객체에 저장
				AddressBookDTO dto = new AddressBookDTO(dname, daddress, dphone, demail);
				// ArrayList객체에 원소를 넣는 것은 add(원소 객체)메서드를 사용함
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	int deleteDB(String phone) {
		int result = 0;
		String sql = "DELETE FROM ADDRESSBOOK WHERE PHONE = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, phone);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	int updateDB(AddressBookDTO dto) {
		int result = 0;
		String sql = "UPDATE ADDRESSBOOK SET NAME = ?, ADDRESS = ?, " + "EMAIL = ? WHERE PHONE = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getAddress());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getPhone());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}