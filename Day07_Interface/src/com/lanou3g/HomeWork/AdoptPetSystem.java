package com.lanou3g.HomeWork;

import java.util.Scanner;

public class AdoptPetSystem {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PetType pet = new PetType();
		System.out.println("-----------��ӭ������������ϵͳ----------");
		System.out.println("-----------�����Ҫ�����ĳ���������ְ�----");
		String PetName = scanner.nextLine();
		pet.setName(PetName);
		System.out.println("-----��ѡ��Ҫ�����ĳ�������:-----");
		System.out.println("1.���һ�Ժ����ˣ�ӵĹ���??");
		System.out.println("2.����������ҫ��Ʒ��Q��??");
		int input = scanner.nextInt();
		switch(input) {
		case 1:
			main1(PetName);
			break;
		case 2:
			main2(PetName);
			break;
		default:
			System.out.println("ѡ�����Ŷ!!!");
			break;
		}
		System.out.println("���Ƿ��о��ò�����������������ĳ�����?");
		System.out.println("1.������������ĳ���!!!");
		System.out.println("2.�Ҿ�������һﻹ������,��һ����!");
		System.out.println("3.������,�Ҿ���������ͦ�õ�!!");
		int inputAgain = scanner.nextInt();
		switch (inputAgain) {
		case 1:
			System.out.println("��Ǹ,��ϵͳֻ������һ�ν���!!!");
			break;
		case 2:
			System.out.println("����?�ѳ��ﻹ����,����!!!");
			break;
		case 3:
			System.out.println("�Ͻ��߸Ͻ���,������������!!!");
			break;
		default:
			System.out.println("ѡ����!!!Ҫ�����Ѷ��ٱ�!!!");
			break;
		}
		
	}
	@SuppressWarnings("resource")
	public static void main1(String args) {
		Scanner scanner = new Scanner(System.in);
		TypeDog dog = new TypeDog();
		System.out.println("-----��ѡ�񹷹���Ʒ��:-----");
		System.out.println("1.ɫɫ��̩��(�ٺٺ�!��Ҫ�����ȥ��\r\t���Ǽ��﷽Բ�����è������\r\t��Ҫ���ٴ��ģ�ķ�ֳʢ��!)");
		System.out.println("2.ɵɵ�Ķ���(������!�Ͻ��ظϽ���\r\t��������\r\t�����������κε��˴�ɹ�ʶ!)");
		int input = scanner.nextInt();
		if (input == 1) {
			dog.setName(args);
			dog.setVariety("ɫɫ��̩��");
			dog.setHealthIndex(89);
			dog.setIntimacy(100);
			dog.selfIntroduction();
		}else if(input == 2){
			dog.setName(args);
			dog.setVariety("ɵɵ�Ķ���");
			dog.setHealthIndex(98);
			dog.setIntimacy(75);
			dog.selfIntroduction();
		}
		else {
			System.out.println("ѡ�����Ŷ!!!");
		}
	}
	@SuppressWarnings("resource")
	public static void main2(String args) {
		Scanner scanner = new Scanner(System.in);
		TypePenguin penguin = new TypePenguin();
		System.out.println("-----��ѡ������Ʒ��:-----");
		System.out.println("1.��˧����Q��");
		System.out.println("2.�������Q��");
		int input = scanner.nextInt();
		if (input == 1) {
			penguin.setName(args);
			penguin.setSex("��˧����Q��");
			penguin.setHealthIndex(99);
			penguin.setIntimacy(12);
			penguin.selfIntroduction();
		}else if(input == 2){
			penguin.setName(args);
			penguin.setSex("�������Q��");
			penguin.setHealthIndex(88);
			penguin.setIntimacy(25);
			penguin.selfIntroduction();
		}
	}

}