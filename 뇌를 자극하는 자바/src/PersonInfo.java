/**
 * 2018. 5. 3. Dev By Jeong.K.S
 * 
 * PersonInfo.java
 */

public class PersonInfo {

	public static void main(String[] args) {

		// Class ����
		Person obj;

		// �Ű����� ���� default ������ ȣ���Ͽ� ��ü����
		obj = new Person();

		// String �Ű����� 1���ִ� ������ ȣ���Ͽ� ��ü����
		// person = new Person("ȫ�浿");

		// String, int �Ű����� 2���ִ� ������ ȣ���Ͽ� ��ü����
		// person = new Person("ȫ�浿", 20);

		// int,String �Ű����� 2���ִ� ������ ȣ���Ͽ� ��ü����
		obj = new Person(20, "ȫ�浿");

		// �޼ҵ� ȣ��
		obj.showPerson(obj);
		obj.showPerson();
		
		//System.out.println(obj);

	}

}