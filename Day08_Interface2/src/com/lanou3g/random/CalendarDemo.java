package com.lanou3g.random;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CalendarDemo {
	public static void main(String[] args) {
		
		Date date = new Date();
//		Fri Dec 01 16:23:22 CST 2017 
		System.out.println(date.toString());
//		Fri Dec 01 16:25:56 CST 2017
		System.out.println(date);
		
		System.out.println(new CalendarDemo());
		// ��������ϵͳʱ��
		System.out.println(System.currentTimeMillis());
		
		long l = System.currentTimeMillis();
		
		
		// �������԰������ǽ������ʱ��
		// ת���������ܿ������ַ���
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = df.format(l);
		System.out.println(time);
	}

	
}