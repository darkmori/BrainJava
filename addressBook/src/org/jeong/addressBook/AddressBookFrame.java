/*
 * java.awt와 javax.swing을 이용한 GUI창 클래스
 * 2017.12.11 작성시작
 * 2017.12. 작성완료
 * 작성자: Jeong ks
 */

package org.jeong.addressBook;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddressBookFrame extends JFrame {
	// 프로젝트에서 사용할 멤버 변수 정의
	Container cpane;
	JLabel name;
	JLabel address;
	JLabel phone;
	JLabel email;
	JTextField nameText;
	JTextField addressText;
	JTextField phoneText;
	JTextField emailText;
	JButton save;
	JButton delete;
	JButton update;
	JButton forward;
	JButton search;
	JButton back;
	JButton clear;
	JButton exit;

	// Swing울 이용한 Frame클래스는 JFrame을 상속해서 만들어줌
	// JFrame은 타이틀바,창조절버튼.테두리를 제공하는 기본창으로 Container
	// 파라메터로 문자열로된 이름(타이틀방의 제목)을 받는 생성자를 각성
	public AddressBookFrame(String title) {
		// title을 타이틀바 제목으로 사용하려면 JFrame의 생성자중 이름처리 생성자를 이용
		super(title);
		// 클래스 크기설정
		setSize(240, 300);// 가로 240, 세로 300px로 프레임 크기 설정
		// 창크기 조절을 비허용
		setResizable(false);
		// 나가기 설정(프로그램 종료설정)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// button,텍스트입력창, 라벨 등의 GUI 구성 요소를 만들고 frame창에 배치해주는 메소드를 호출
		makeUI();
		// Frame창은 보여주기 메소드를 실행해야함 보임
		setVisible(true);

	}

	void makeUI() {// 컴포넌트를 만들고 프레임에 배치해주는 메소드
		// 프레임의 컴퍼넌트 배치 가능 영역을 구함
		Container cpane = this.getContentPane();
		// cpane 컨테이너에 컴퍼넌트를 배치하므로 layout 설정을 cpane에 함
		setLayout(new GridBagLayout());
		// JLabel 컴포넌트생성
		name = new JLabel("Name"); // 내용인 Name이 JLabel 객체생성
		address = new JLabel("Address");
		phone = new JLabel("Phone");
		email = new JLabel("Email");

		// JtextField객체 생성
		nameText = new JTextField(20);
		addressText = new JTextField(20);
		phoneText = new JTextField(20);
		emailText = new JTextField(20);

		// JButton객체 생성
		save = new JButton("Save"); // 버튼의 이름을 가진 객체 생성
		delete = new JButton("Delete");
		update = new JButton("Update");
		back = new JButton("<<");
		search = new JButton("Search");
		forward = new JButton(">>");
		clear = new JButton("Clear");
		exit = new JButton("Exit");

		// GridBagLayout방식으로 생성된 각각의 컴포넌트를 Container객체 cpane에 배치
		// 배치 형식은 GridBagConstraints객체와 멤버변수 (속성)을 이용하여 설정
		// 행이 0, 열이 0인 위치에 배치
		GridBagConstraints gc00 = new GridBagConstraints(); // GridBagConstraints객체 생성
		gc00.gridy = 0;
		gc00.gridx = 0;
		// 차지하는 가로,세로인 gridwidth,gridheight는 기본값1이므로 설정 안해도 무방
		// 여백을 표시하는 insets속성 지정
		gc00.insets = new Insets(5, 5, 5, 5);
		// cpane컨테이너에 JLabel객체 name을 배치
		cpane.add(name, gc00); // 첫번째 파라메터로 배치할 컴포넌트 객체, 두번째에 GridBagConstraints 객체

		// 행이 0번, 열이 1,2 통합사용
		GridBagConstraints gc01 = new GridBagConstraints();
		gc01.gridy = 0;
		gc01.gridx = 1;
		gc01.gridwidth = 2; // 1번열과 2번열을 통합
		gc01.insets = new Insets(5, 5, 5, 5);
		// 배치위치릐 컴포넌트 나버지 공백처리
		gc01.fill = GridBagConstraints.BOTH;
		cpane.add(nameText, gc01);

		// 행이 1번, 열이 0
		GridBagConstraints gc10 = new GridBagConstraints(); // GridBagConstraints객체 생성
		gc10.gridy = 1;
		gc10.gridx = 0;
		// 차지하는 가로,세로인 gridwidth,gridheight는 기본값1이므로 설정 안해도 무방
		// 여백을 표시하는 insets속성 지정
		gc10.insets = new Insets(5, 5, 5, 5);
		// cpane컨테이너에 JLabel객체 address을 배치
		cpane.add(address, gc10);

		// 행 1번, 열 1번 2칸 통합
		GridBagConstraints gc11 = new GridBagConstraints();
		gc11.gridy = 1;
		gc11.gridx = 1;
		gc11.gridwidth = 2; // 1번열과 2번열을 통합
		gc11.insets = new Insets(5, 5, 5, 5);
		// 배치위치릐 컴포넌트 나버지 공백처리
		gc11.fill = GridBagConstraints.BOTH;
		cpane.add(addressText, gc11);

		GridBagConstraints gc20 = new GridBagConstraints();
		gc20.gridy = 2;
		gc20.gridx = 0;
		gc20.insets = new Insets(5, 5, 5, 5);
		cpane.add(phone, gc20);

		GridBagConstraints gc21 = new GridBagConstraints();
		gc21.gridy = 2;
		gc21.gridx = 1;
		gc21.gridwidth = 2;
		gc21.insets = new Insets(5, 5, 5, 5);
		gc21.fill = GridBagConstraints.BOTH;
		cpane.add(phoneText, gc21);

		GridBagConstraints gc30 = new GridBagConstraints();
		gc30.gridy = 3;
		gc30.gridx = 0;
		gc30.insets = new Insets(5, 5, 5, 5);
		cpane.add(email, gc30);

		GridBagConstraints gc31 = new GridBagConstraints();
		gc31.gridy = 3;
		gc31.gridx = 1;
		gc31.gridwidth = 2;
		gc31.insets = new Insets(5, 5, 5, 5);
		gc31.fill = GridBagConstraints.BOTH;
		cpane.add(emailText, gc31);

		GridBagConstraints gc40 = new GridBagConstraints();
		gc40.gridy = 4;
		gc40.gridx = 0;
		gc40.insets = new Insets(5, 5, 5, 5);
		cpane.add(save, gc40);

		GridBagConstraints gc41 = new GridBagConstraints();
		gc41.gridy = 4;
		gc41.gridx = 1;
		gc41.insets = new Insets(5, 5, 5, 5);
		gc41.fill = GridBagConstraints.BOTH;
		cpane.add(delete, gc41);

		GridBagConstraints gc42 = new GridBagConstraints();
		gc42.gridy = 4;
		gc42.gridx = 2;
		gc42.insets = new Insets(5, 5, 5, 5);
		gc42.fill = GridBagConstraints.BOTH;
		cpane.add(update, gc42);

		GridBagConstraints gc50 = new GridBagConstraints();
		gc50.gridy = 5;
		gc50.gridx = 0;
		gc50.insets = new Insets(5, 5, 5, 5);
		gc50.fill = GridBagConstraints.BOTH;
		cpane.add(back, gc50);

		GridBagConstraints gc51 = new GridBagConstraints();
		gc51.gridy = 5;
		gc51.gridx = 1;
		gc51.insets = new Insets(5, 5, 5, 5);
		gc51.fill = GridBagConstraints.BOTH;
		cpane.add(search, gc51);

		GridBagConstraints gc52 = new GridBagConstraints();
		gc52.gridy = 5;
		gc52.gridx = 2;
		gc52.insets = new Insets(5, 5, 5, 5);
		gc52.fill = GridBagConstraints.BOTH;
		cpane.add(forward, gc52);

		GridBagConstraints gc61 = new GridBagConstraints();
		gc61.gridy = 6;
		gc61.gridx = 1;
		gc61.insets = new Insets(5, 5, 5, 5);
		gc61.fill = GridBagConstraints.BOTH;
		cpane.add(clear, gc61);

		GridBagConstraints gc62 = new GridBagConstraints();
		gc62.gridy = 6;
		gc62.gridx = 2;
		gc62.insets = new Insets(5, 5, 5, 5);
		gc62.fill = GridBagConstraints.BOTH;
		cpane.add(exit, gc62);

		/**
		 * 이벤트 처리 (Jbutton, JTextField 객체)를 위해 각 컴퍼넌트의 이벤트 처리를 등록해주어야 함
		 * JButton,JTextField컴포넌트는 ActionEvent를 발생 ActionEvent처리를 위한 청취자는
		 * ActionListener인터페이스 이용 Listener객체를 생성하여 각 컴포넌트에 리스너를 등록 컴포넌트
		 * 객체명.addActionListener(리스너 객체);
		 */

		// Listener객체 만들기
		AddressBookListener al = new AddressBookListener(this);
		// this는 AddressBookFrame 자신클래스의 객체임
		// 각각의 컴포넌트 객체에 Listener을 등록해주면 이벤트 발생 여부를 청취
		// 청취중 이벤트가 발생하면 actionPerformed(ActionEvent e)메소드를 콜백
		nameText.addActionListener(al);
		addressText.addActionListener(al);
		phoneText.addActionListener(al);
		emailText.addActionListener(al);
		save.addActionListener(al);
		delete.addActionListener(al);
		update.addActionListener(al);
		forward.addActionListener(al);
		back.addActionListener(al);
		clear.addActionListener(al);
		exit.addActionListener(al);
		search.addActionListener(al);

	};
}
