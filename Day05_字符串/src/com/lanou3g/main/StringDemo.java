package com.lanou3g.main;

public class StringDemo {

	public static void main(String[] args) {
		/**
		 * String���ʾ�ַ���
		 * ע��,�ַ������ǻ�����������
		 */
		
		// �ַ����ǲ��ɱ��,��һ���ַ�����������
		// ���Ͳ����ٷ����仯
		String s1 = "����"+"����";
		String s2 = "����";
		String s3 = new String("����");
		String s4 = new String("����");
		
		
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		
		// equals ���ַ����ķ���
		// ��Ҫ���ַ���,������ʹ���������
		// ����: �ж������ַ����������Ƿ����
		boolean bo = s3.equals(s4);
	}

}
