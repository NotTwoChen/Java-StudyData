package com.lanou3g.study;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		// ���������,ָ��������Ķ���
		// ���Ƕ�̬��һ����
		Person personT = new Teacher();
		Person personD = new Doctor();
		
		Scanner input = new Scanner(System.in);
		while(true) {
		System.out.println("\r\t����1,��ʦ�ɹ�\r\t����2,ҽ���ɹ�\r\t����3,ѧ������");
		// ��ȡ����̨���������ֵ
		// ���������������
		// ��ִ�е��������ʱ,�������̨һֱ����������
		// �����ͻῨ������
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
