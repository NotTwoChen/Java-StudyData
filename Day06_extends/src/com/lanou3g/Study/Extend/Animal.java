package com.lanou3g.Study.Extend;

public class Animal {
	/**
	 * ʲô�Ǽ̳�?
	 * 	�̳���Java�����������˼�����������֮һ
	 * 	��װ/�̳�/��̬
	 * 		������Լ̳и�������Ժͷ���
	 * 		����һ����pig,ʹ��extends�ؼ���
	 * 					�̳�Animal�����
	 */
	
//	public Animal() {
//		System.out.println("-----���ﶯ��-----");
//	}
	
	public Animal(String kind) {
		this.kind = kind;
		System.out.println("������������Ϊ"+kind);
	}
	
	
	
	// ��ʾ����
	private String kind;
	public void sleep() {
		System.out.println("˯��");
	}
}