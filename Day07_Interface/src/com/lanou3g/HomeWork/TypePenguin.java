package com.lanou3g.HomeWork;

public class TypePenguin extends PetType{
	public void selfIntroduction(){
		System.out.println("----------��ϲ����������ɹ�!!!----------");
		System.out.println("�뾲������������������������ҽ���:");
		System.out.println("��������,�������ֽ�"+super.getName()+",�Һܽ���Ŷ!\t\r����ֵ��:"
		+super.getHealthIndex()+"\t\r�����˵����ܶ���"+super.getIntimacy()
		+"\t\r�Ա���"+super.getSex()+".");
	}
}
