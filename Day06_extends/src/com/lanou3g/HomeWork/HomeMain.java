package com.lanou3g.HomeWork;

public class HomeMain {
	public static void main(String[] args) {
		Father father = new Father();
		// 创建好father之后,给他一个名字
		father.setName("第一个类第一个属性");
		Mother mother = new Mother();
		mother.setName("第二个类第一个属性");
		Child child = new Child();
		child.setName("第三个类第一个属性");
		
		father.setWife(mother);
		father.setChild(child);
		
		father.showFamily();
	}
}
