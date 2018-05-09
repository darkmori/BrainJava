/**
 * 2018. 5. 3. Dev By Jeong.K.S
 * 
 * Person.java
 */

public class Person {

	String name;
	int age;

	// ������
	public Person() {
	}

	// �Ű����� 1���ִ� ������
	public Person(String name) {
		this.name = name;
	}

	// �Ű����� 2��(String,int)�ִ� ������
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person(String name,int age) �Ű����� 2���ִ� ������ ȣ��");
	}

	// �Ű����� 2��(String,int)�ִ� ������
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		System.out.println("Person(int age, String name) �Ű����� 2���ִ� ������ ȣ��");

	}

	public void showPerson() {
		System.out.println("�̸�: " + name + ", ����: " + age);
	}

	public void showPerson(Person obj) {
		System.out.println("showPerson(Person obj)�޼ҵ� ȣ��");
		System.out.println("�̸�: " + name);
		System.out.println("����: " + age + "�Դϴ�.");

		obj.name = "ichi";
		obj.age = 15;
	}
}