package com.lanou3g.Study.Extend;

public class Pig extends Animal {
	public Pig(String kind) {
		super(kind);
		// TODO 自动生成的构造函数存根
	}

	/*
	 * extends关键字:继承
	 * 		A extends B
	 * 		就是A类继承B类,只在类的声明时使用
	 */
	
	
	
	// 子类继承父类的属性或方法
	// 然后又定义了自己独有的属性或方法
	// 这个过程叫扩展
	// 被杀掉吃肉了
	public void beKilledToMeat() {
		System.out.println("被杀掉吃肉了");
	}
}
