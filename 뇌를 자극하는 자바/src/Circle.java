/**
 * 2018. 5. 2. Dev By Jeong.K.S
 * 
 * Circle.java
 */

public class Circle {
	int radius; // ���� ������ �ʵ�
	String name; // ���� �̸� �ʵ�

	public Circle() { // ���� ������
	}

	public double getArea() { // ���� ���� ��� �ޙ�,
		return 3.14 * radius * radius;
	}

	public static void main(String[] args) {
		Circle pizza;
		pizza = new Circle(); // Circle ��ü����
		pizza.radius = 10; // ������ �������� 10���� ����
		pizza.name = "�ڹ�����"; // ������ ���� �˾Ƴ���
		double pizza_area = pizza.getArea();
		System.out.println(pizza.name + "�� ������ " + pizza_area);

		Circle donut = new Circle(); // Circle ��ü ����
		donut.radius = 2; // ������ �������� 2�� ����
		donut.name = "�ڹٵ���"; // ������ �̸� ����
		double donut_area = donut.getArea(); // ������ ���� �˾Ƴ���

		System.out.println(donut.name + "�� ������ " + donut_area);

	}
}