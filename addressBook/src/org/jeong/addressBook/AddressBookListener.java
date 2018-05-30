/**
 * ActionEvent처리 Listener클래스(JButton,JTextField 콤포넌트에서 발생하는 이벤트 처리
 * Listener클래스는 ActionListener인터페이스를 구현하는 클래스
 * ActionListener인터페이스에는 추상메서드가 actionPerformed(ActionEvent e) 하나만 있음
 */
package org.jeong.addressBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AddressBookListener implements ActionListener {
	// 멤버 변수 f는 AddressBookFrame의 변수
	AddressBookFrame f;
	// 레코드 번호
	int recordNum = -1;
	// ArrayList객체를 멤버 객체 person으로 선언;
	ArrayList<AddressBookDTO> person = new ArrayList<AddressBookDTO>();
	// DAO객체 변수 선언
	AddressBookDAO dao;

	// 생성자를 만듬
	public AddressBookListener(AddressBookFrame f) {
		this.f = f;
		// DB접속(드라이버 로딩 및 connect처리하는 AddressBookDAO객체를 생성하여
		// 멤버 변수에 저장
		dao = new AddressBookDAO();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이 메서드는 ActionEvent를 발생하는 콤포넌트에 액션을 주면 자동으로 호출
		// 각 콤포넌트별로 처리해야할 내용을 작성
		// ActionEvent 객체 e를 인자로 받는데 e에는 이벤트 관련 정보가 들어 있음
		// 이벤트가 일어난 콤포넌트 객체를 알아내는 메서드는 public Object getSource()
		if (e.getSource() == f.save) { // save버튼을 클릭시 발생하는 이벤트 처리
			// 문자 입력창의 내용을 데이터베이스에 저장
			savePerson(); // 저장 메서드
			clear(); // 화면 클리어
		} else if (e.getSource() == f.delete) {
			deletePerson(); // 데이터베이스에서 해당 레코드 삭제
			clear();
		} else if (e.getSource() == f.update) {
			updatePerson();
			clear();
		} else if (e.getSource() == f.search) {
			searchPerson();
		} else if (e.getSource() == f.forward) {
			forward();
		} else if (e.getSource() == f.back) {
			back();
		} else if (e.getSource() == f.clear) {
			clear();
		} else if (e.getSource() == f.exit) {
			System.exit(0); // 프로그램 종료
		}
	}

	void savePerson() {
		// save에 필요한 각각의 값을 얻어냄
		String sname = f.nameText.getText();
		String saddress = f.addressText.getText();
		String sphone = f.phoneText.getText();
		String semail = f.emailText.getText();
		if (sname == null || saddress == null || sphone == null || semail == null || sname.equals("")
				|| saddress.equals("") || sphone.equals("") || semail.equals("")) {
			// 입력항목중 누락된 콤포넌트가 있으면 안내 메세지 창인 JOptionPane창을 띄워줌
			try {
				JOptionPane.showMessageDialog(f, "입력이 안된 항목이 존재 합니다");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 입력이 정상적일때 처리(AddressBookDAO클래스를 이용 데이터베이스에 저장)
			// 임시
			System.out.println("save가 정상으로 처리 되었습니다.");
			// DB처리를 위해 AddressBookDAO클래스에 save처리 메서드 saveDB를 호출
			// 입력창에 입력된 값을(sname,saddress,sphone,semail변수값)을
			// AddressBookDTO객체에 저장해서 saveDB인자로 사용
			AddressBookDTO dto = new AddressBookDTO(sname, saddress, sphone, semail);
			int result = dao.saveDB(dto);
			if (result < 1) {
				try {
					JOptionPane.showMessageDialog(f, "동일전화번호가 존재");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					JOptionPane.showMessageDialog(f, "DB에 저장 성공");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	void deletePerson() {
		String phone = f.phoneText.getText();
		if (phone == null || phone.equals("")) {
			JOptionPane.showMessageDialog(f, "전화번호가 입력이 없습니다");
		} else {
			int result = dao.deleteDB(phone);
			if (result <= 0) {
				JOptionPane.showMessageDialog(f, "지울 레코드가 없습니다");
			} else {
				JOptionPane.showMessageDialog(f, "지운 레코드의 수는 " + result + "입니다");
			}

		}
	}

	void updatePerson() {
		String phone = f.phoneText.getText();
		String name = f.nameText.getText();
		String address = f.addressText.getText();
		String email = f.emailText.getText();

		if (phone == null || phone.equals("")) {
			JOptionPane.showMessageDialog(f, "전화번호가 입력이 없습니다");
		} else if (name == null || address == null || email == null || name.equals("") || address.equals("")
				|| email.equals("")) {
			JOptionPane.showMessageDialog(f, "입력 항목중 누락 항목이 있습니다.");
		} else {
			AddressBookDTO dto = new AddressBookDTO(name, address, phone, email);
			int result = dao.updateDB(dto);
			if (result == 0) {
				JOptionPane.showMessageDialog(f, "업데이트 항목이 없습니다." + "phone을 수정했거나 없는 전화번호를 사용했습니다.");
			} else {
				JOptionPane.showMessageDialog(f, "업데이트 성공");
			}
		}
	}

	void searchPerson() {
		// search버튼을 클릭시 입력창에 아무것도 없으면 전체 레코드를 검색하고
		// name에 입력값이 있으면 name일치 레코드를
		// phone에 있으면 phone일치 레코드를 검색
		String sname = f.nameText.getText();
		String sphone = f.phoneText.getText();
		recordNum = 0;
		// 잔에 검색시 생성된 ArrayList를 clear해주는 것이 좋음
		person.clear();

		person = dao.searchDB(sname, sphone);

		if (person.size() == 0) {
			// ArrayList객체의 원소 갯수는 size()로 구함
			// 배열은 length 멤버변수로 구함
			JOptionPane.showMessageDialog(f, "No records found.");
			clear();
		} else {
			AddressBookDTO personInfo = person.get(recordNum);
			// ArrayList객체인 person의 원소는 dto객체로 구성됨
			// ArrayList객체의 원소는 get(색인번호)로 구함
			// AddressBookDTO는 DAO에 구한 데이터베이스의 레코드값을 객체로 변환
			// dB에 있는 각각의 레코드 컬럼값을 각각의 객체의 멤버변수값에 매칭
			f.nameText.setText(personInfo.getName());
			f.addressText.setText(personInfo.getAddress());
			f.phoneText.setText(personInfo.getPhone());
			f.emailText.setText(personInfo.getEmail());
		}
	}

	void forward() {
		// 다음 레코드 번호를 ArrayList객체 person의 다음 색인번호의 원소값을 출력
		recordNum++;
		// 마지막 색인번호인지 체크(person은 원소갯수보다 1이 적음)
		if (recordNum >= person.size()) {
			JOptionPane.showMessageDialog(f, "검색된 레코드의 갯수 초과");
			// 더이상 forward버튼이 클릭이 안되도록 설정
			f.forward.setEnabled(false);
			// back으로는 동작이 가능한도록 설정
			f.back.setEnabled(true);
			// 색인번호는 마지막 색인번호로 설정
			recordNum--;
		} else {
			f.back.setEnabled(true);
			AddressBookDTO dto = person.get(recordNum);
			f.nameText.setText(dto.getName());
			f.addressText.setText(dto.getAddress());
			f.phoneText.setText(dto.getPhone());
			f.emailText.setText(dto.getEmail());

		}

	}

	void back() {
		recordNum--;
		if (recordNum < 0) {
			JOptionPane.showMessageDialog(f, "맨 처음 레코드입니다.");
			f.forward.setEnabled(true);
			f.back.setEnabled(false);
			recordNum++;
		} else {
			f.forward.setEnabled(true);
			AddressBookDTO dto = person.get(recordNum);
			f.nameText.setText(dto.getName());
			f.addressText.setText(dto.getAddress());
			f.phoneText.setText(dto.getPhone());
			f.emailText.setText(dto.getEmail());

		}
	}

	void clear() {
		f.nameText.setText("");
		f.addressText.setText("");
		f.phoneText.setText("");
		f.emailText.setText("");

		if (person.size() == 0)
			person.clear(); // search시 만들어진 데이터배열을 삭제
		recordNum = -1; // recordNum은 ArrayList의 색인번호로 사용되므로
		// clear시는 색인번호 최소값보다 적은 -1설정
		f.forward.setEnabled(true);
		f.back.setEnabled(true);
	}

}
