package com.lanou3g.extend;

public class Car {
	private int wheels;// 轮子个数
	private String color;
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		System.out.println("----我是父类中的setColor方法"+color);
		this.color = color;
	}
	
	
}
