package com.lanou3g.study;

public class Company2 {

	/*
	 * ��������һ����������õ�ʱ��
	 * �����һ������Ķ���,��������Ķ�����
	 * 
	 * 
	 */
	
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void work() {
		person.work();
	}
	
	
	
	
}
