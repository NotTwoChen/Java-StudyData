package com.lanou3g.HomeWork;

public class Dog {
	
	/*
	 * ���췽��������:
	 * ��������ͬ(���췽���ķ�������������)
	 * �����б�ͬ
	 * 		�����ĸ���,����������,������˳��
	 * ����������,ֻҪ��һ����ͬ,�ǲ����б���ǲ�ͬ��
	 */
	public Dog() {
		System.out.println("����Ĭ�ϵĿղι��췽��");
	}
	public Dog(String name) {
		System.out.println("���Ǵ������Ĺ��췽��,����ֵΪ"+name);
	}
	
	public Dog(int age, String name) {
		
	}
	public Dog(String name, int age) {
		
	}
	
	/*
	 * ��������������
	 * 		��������ͬ,�����б�ͬ
	 * 		�뷵��ֵ��Ȩ�����η��޹�
	 */
	public void eatBone() {
		System.out.println("����Ϊ���ڳԹ�ͷ");
	}
	public String eatBone(String n) {
		return "��ͷ";
	}
}
