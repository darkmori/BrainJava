/**
 * 2018. 5. 3. Dev By Jeong.K.S
 * 
 * ConstrEample2.java
 */

public class ConstrEample2 {
	public static void main(String[] args) {
		SubscriberInfo obj1, obj2;
		obj1 = new SubscriberInfo("연흥부", "poorman", "zebi");
		obj2 = new SubscriberInfo("연놀부", "richman", "money", "02-000-0000", "타워팰리스");

		printSubscriberInfo(obj1);
		printSubscriberInfo(obj2);
	}

	static void printSubscriberInfo(SubscriberInfo obj) {
		System.out.println("이름: " + obj.name);
		System.out.println("아이디: " + obj.id);
		System.out.println("비밀번호: " + obj.password);
		System.out.println("전화번호: " + obj.phoneNo);
		System.out.println("주소: " + obj.address);
		System.out.println(); // 줄바꿈 문자 출력
	}

}
