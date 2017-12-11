package com.lanou3g.extend;

public class BigCar extends Car {
	// 定义在类的{}中的属性
	// 叫做成员属性或成员变量
	// show方法中定义的w叫做局部变量
	// 局部变量,只在定义它的{}中有效
	// 这个变量有效范围,被称为变量的作用域
	private String name = "大卡车";
	
	public void pullGoods() {
		System.out.println("拉货去了");
	}
	
	public void show() {
		// 因为wheels是私有的,所以子类无法访问,也就是无法复制
		// wheels = 4;
		
		
		int wheels = getWheels();
		System.out.println("轮胎个数为:"+wheels);
		
	}

	@Override
	public int getWheels() {
		// TODO 自动生成的方法存根
		return super.getWheels();
	}

	@Override
	public void setWheels(int wheels) {
		// TODO 自动生成的方法存根
		super.setWheels(wheels);
	}

	@Override
	public String getColor() {
		// TODO 自动生成的方法存根
		return super.getColor();
	}

	@Override
	public void setColor(String color) {
		// TODO 自动生成的方法存根
		System.out.println("我是子类中的setColor方法"+color);
		super.setColor(color);
	}
	
	public void showThis() {
		/**
		 * this是在调用本类自己的方法
		 * super是在调用父类的方法
		 * this叫做本类对象
		 * 但是一般没有管super叫父类对象
		 * 
		 * this可以调用本类的属性/方法
		 */
		this.setColor("子类设置黑色");
		super.setColor("父类设置绿色");
	}
}
