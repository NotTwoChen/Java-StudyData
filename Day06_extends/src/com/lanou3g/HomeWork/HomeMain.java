package com.lanou3g.HomeWork;

public class HomeMain {
	public static void main(String[] args) {
		Father father = new Father();
		// ������father֮��,����һ������
		father.setName("��һ�����һ������");
		Mother mother = new Mother();
		mother.setName("�ڶ������һ������");
		Child child = new Child();
		child.setName("���������һ������");
		
		father.setWife(mother);
		father.setChild(child);
		
		father.showFamily();
	}
}