package com.lanou3g.extend;

public class BigCar extends Car {
	// ���������{}�е�����
	// ������Ա���Ի��Ա����
	// show�����ж����w�����ֲ�����
	// �ֲ�����,ֻ�ڶ�������{}����Ч
	// ���������Ч��Χ,����Ϊ������������
	private String name = "�󿨳�";
	
	public void pullGoods() {
		System.out.println("����ȥ��");
	}
	
	public void show() {
		// ��Ϊwheels��˽�е�,���������޷�����,Ҳ�����޷�����
		// wheels = 4;
		
		
		int wheels = getWheels();
		System.out.println("��̥����Ϊ:"+wheels);
		
	}

	@Override
	public int getWheels() {
		// TODO �Զ����ɵķ������
		return super.getWheels();
	}

	@Override
	public void setWheels(int wheels) {
		// TODO �Զ����ɵķ������
		super.setWheels(wheels);
	}

	@Override
	public String getColor() {
		// TODO �Զ����ɵķ������
		return super.getColor();
	}

	@Override
	public void setColor(String color) {
		// TODO �Զ����ɵķ������
		System.out.println("���������е�setColor����"+color);
		super.setColor(color);
	}
	
	public void showThis() {
		/**
		 * this���ڵ��ñ����Լ��ķ���
		 * super���ڵ��ø���ķ���
		 * this�����������
		 * ����һ��û�й�super�и������
		 * 
		 * this���Ե��ñ��������/����
		 */
		this.setColor("�������ú�ɫ");
		super.setColor("����������ɫ");
	}
}