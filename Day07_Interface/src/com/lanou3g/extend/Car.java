package com.lanou3g.extend;

public class Car {
	private int wheels;// ���Ӹ���
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
		System.out.println("----���Ǹ����е�setColor����"+color);
		this.color = color;
	}
	
	
}
