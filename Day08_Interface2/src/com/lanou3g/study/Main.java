package com.lanou3g.study;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		// 父类的引用,指向了子类的对象
		// 这是多态的一部分
		Person personT = new Teacher();
		Person personD = new Doctor();
		
		Scanner input = new Scanner(System.in);
		while(true) {
		System.out.println("\r\t输入1,老师干哈\r\t输入2,医生干哈\r\t输入3,学生疯了");
		// 获取控制台输入的整数值
		// 这个方法有阻塞性
		// 当执行到这个方法时,如果控制台一直不输入内容
		// 则程序就会卡在这里
		int choice = input.nextInt();
		Company2 company2 = new Company2();
		
		if(choice == 1) {
			Teacher teacher = new Teacher();
			company2.setPerson(teacher);
		}else if(choice == 2) {
			Doctor doctor = new Doctor();
			company2.setPerson(doctor);
		}else if(choice == 3) {
			Student student = new Student();
			company2.setPerson(student);
		}
		
		company2.work();
	}
	}
}
