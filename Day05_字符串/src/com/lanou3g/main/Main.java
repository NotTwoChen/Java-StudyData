package com.lanou3g.main;

import test.Student;

public class Main {
	public static void main (String [] args) {
		Student student = new  Student();
		student.smile();
		// cry��private���ε�,������Student�������Ҳ���
//		student.cry();
		
		// angry��protected���ε�,������test������,�Ҳ���
		// ��ͽ�ͬ������
		// ��Ϊmain���ڵİ�,��Student��������ڵİ�����ͬһ����
		// ���Բ�����
//		student.angry();
		
		
		// sad����������,û��Ȩ�����η�
		// ��ʾĬ�ϵ�,ֻ��ͬ���¿���ʹ��
//		student.sad();
	}
}
