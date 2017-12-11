package com.lanou3g.study;

public class Company2 {

	/*
	 * 当我声明一个父类的引用的时候
	 * 你给我一个父类的对象,或者子类的对象都行
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
