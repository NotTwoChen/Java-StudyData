package com.lanou3g.change;

public class Main {
	public static void main(String[] args) {
		// ���������ָ��������Ķ���
		Father fason = new Son();
		
//		fason = new Daughter();
		
		// ���������ֻ���ҵ�����ķ���
		// �Ҳ�������Ķ��з���
		fason.eat();
		
//		Son bigSon1 = (Son)fason;
		// ����ת���쳣
		
		if (fason instanceof Son) {
			// ���fason�������ָ��Ķ�������Ϊson
			// ��ô���ǿ��Խ���ǿ������ת��
			System.out.println("ʵ���������д�ɹ�!");
			// ()��д�ľ���Ҫǿ��ת��������
			Son bigSon = (Son) fason;
			bigSon.eat();
			bigSon.WatchTV();
		}
		
		
	}
}
