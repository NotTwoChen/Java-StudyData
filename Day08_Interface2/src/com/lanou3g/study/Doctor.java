package com.lanou3g.study;

import inter.Work;

public class Doctor extends Person implements Work{
	public void work() {
		System.out.println("���̾ƾ����Ǳ���");
	}

	@Override
	public void goHome() {
		System.out.println("��������,�ؼ�˯��");
	}
}
