package com.lanou3g.Study.Extend;

public class Animal {
	/**
	 * 什么是继承?
	 * 	继承是Java中面向对象编程思想的三大特性之一
	 * 	封装/继承/多态
	 * 		子类可以继承父类的属性和方法
	 * 		创建一个类pig,使用extends关键字
	 * 					继承Animal这个类
	 */
	
//	public Animal() {
//		System.out.println("-----动物动物-----");
//	}
	
	public Animal(String kind) {
		this.kind = kind;
		System.out.println("这个动物的种族为"+kind);
	}
	
	
	
	// 表示种族
	private String kind;
	public void sleep() {
		System.out.println("睡觉");
	}
}
