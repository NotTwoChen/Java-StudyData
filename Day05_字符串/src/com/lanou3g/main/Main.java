package com.lanou3g.main;

import test.Student;

public class Main {
	public static void main (String [] args) {
		Student student = new  Student();
		student.smile();
		// cry是private修饰的,所以在Student类外面找不到
//		student.cry();
		
		// angry是protected修饰的,所以在test包外面,找不到
		// 这就叫同包可用
		// 以为main所在的包,与Student这个类所在的包不是同一个包
		// 所以不可用
//		student.angry();
		
		
		// sad方法声明中,没有权限修饰符
		// 表示默认的,只有同包下可以使用
//		student.sad();
	}
}
