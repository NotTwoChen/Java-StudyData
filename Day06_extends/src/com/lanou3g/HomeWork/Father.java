package com.lanou3g.HomeWork;


public class Father {
	/*
	 * ��������,��һ�����Ӻ�һ������
	 * ��������û��Mother���Child��
	 * ��������ȥ����һ��
	 */
	// ������������,�ֱ��ʾ������׵����Ӻͺ���
	private Mother wife;
	private Child child;
	
	// ��ʾ���׵�����
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWife(Mother wife) {
		this.wife = wife;
	}
	
	public void setChild(Child child) {
		this.child = child;
	}
	
	public void showFamily() {
		System.out.println(name + "��������" + wife.getName() + ",���ĺ�����" + child.getName());
	}
}
