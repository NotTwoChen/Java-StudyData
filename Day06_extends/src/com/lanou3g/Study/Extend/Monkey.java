package com.lanou3g.Study.Extend;

public class Monkey extends Animal{

	public Monkey() {
		// super()�����ڵ��ø���ĿղεĹ��췽��
		// super("����")�����ڵ��ø���Ĳ�������ΪString�Ĺ��췽��
		super("����");
		System.out.println("I'm  �����ʥ");
	}

	@Override
	public void sleep() {
		// super.sleep()���ڵ��ø����sleep����
		System.out.println("���Ǻ��ӵ�˯������");
		super.sleep();
	}
	
	
}
