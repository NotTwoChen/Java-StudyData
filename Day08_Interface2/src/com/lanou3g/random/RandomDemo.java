package com.lanou3g.random;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		// ȡһ�������
		// ��Ҫ�õ�random���������
		Random random = new Random();
		int random1 =
		random.nextInt();
		
		System.out.println(random1);
		
		// ȡһ��30~45֮��������
		
		// ��һ��:ȡһ��0��10֮��������
		// nextInt(bound)���ܵĲ���
		// ��һ������ҿ�������[0,bound)
		int random2 = random.nextInt(11);
		System.out.println(random2);
		// �ڶ���:ȡһ��30~45֮��������
		int random3 = random.nextInt(45-30+1)+30;
		System.out.println(random3);
		// ���ȡһ��true��false
		boolean random4 = random.nextBoolean();
		System.out.println(random4);
		
		
	}

}