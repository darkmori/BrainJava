/**
 * set,get클래스로 데이터 베이스의 레코드값을 하나의 객체로 생성
 */

package org.jeong.addressBook;

public class AddressBookDTO {
	// 데이터베이스의 각 칼럼에 대응하는 멤버변수
	private String name;
	private String address;
	private String phone;
	private String email;

	// 생성자
	public AddressBookDTO(String name, String address, String phone, String email) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	// get,set메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
