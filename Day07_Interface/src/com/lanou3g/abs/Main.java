package com.lanou3g.abs;

public class Main {
	public static void main(String[] args) {
		Sunny sun = new Sunny();
		RainDay rainDay = new RainDay();
		
		sun.description();
		rainDay.description();
		
		Weather weather = new Weather() {

			@Override
			public void description() {
				// TODO 自动生成的方法存根
				
			}};
		Person person = new Person() {};
	}
}
