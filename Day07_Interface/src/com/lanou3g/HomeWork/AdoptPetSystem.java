package com.lanou3g.HomeWork;

import java.util.Scanner;

public class AdoptPetSystem {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PetType pet = new PetType();
		System.out.println("-----------欢迎来到宠物领养系统----------");
		System.out.println("-----------请给您要领养的宠物起个名字吧----");
		String PetName = scanner.nextLine();
		pet.setName(PetName);
		System.out.println("-----请选择要领养的宠物类型:-----");
		System.out.println("1.看家护院逗乐耍杂的狗狗??");
		System.out.println("2.老马集团荣耀出品的Q鹅??");
		int input = scanner.nextInt();
		switch(input) {
		case 1:
			main1(PetName);
			break;
		case 2:
			main2(PetName);
			break;
		default:
			System.out.println("选择错误哦!!!");
			break;
		}
		System.out.println("你是否有觉得不满或者想领养更多的宠物呢?");
		System.out.println("1.我想领养更多的宠物!!!");
		System.out.println("2.我觉得这个家伙还烦人呐,换一个吧!");
		System.out.println("3.不用了,我觉得这样就挺好的!!");
		int inputAgain = scanner.nextInt();
		switch (inputAgain) {
		case 1:
			System.out.println("抱歉,本系统只和你做一次交易!!!");
			break;
		case 2:
			System.out.println("烦人?把宠物还给我,滚蛋!!!");
			break;
		case 3:
			System.out.println("赶紧走赶紧走,别打搅我做生意!!!");
			break;
		default:
			System.out.println("选错了!!!要我提醒多少遍!!!");
			break;
		}
		
	}
	@SuppressWarnings("resource")
	public static void main1(String args) {
		Scanner scanner = new Scanner(System.in);
		TypeDog dog = new TypeDog();
		System.out.println("-----请选择狗狗的品种:-----");
		System.out.println("1.色色的泰迪(嘿嘿嘿!这要是领回去了\r\t怕是家里方圆百里的猫狗虫鸟\r\t都要面临大规模的繁殖盛季!)");
		System.out.println("2.傻傻的二哈(哈哈哈!赶紧地赶紧地\r\t把它带走\r\t足以让您和任何敌人达成共识!)");
		int input = scanner.nextInt();
		if (input == 1) {
			dog.setName(args);
			dog.setVariety("色色的泰迪");
			dog.setHealthIndex(89);
			dog.setIntimacy(100);
			dog.selfIntroduction();
		}else if(input == 2){
			dog.setName(args);
			dog.setVariety("傻傻的二哈");
			dog.setHealthIndex(98);
			dog.setIntimacy(75);
			dog.selfIntroduction();
		}
		else {
			System.out.println("选择错误哦!!!");
		}
	}
	@SuppressWarnings("resource")
	public static void main2(String args) {
		Scanner scanner = new Scanner(System.in);
		TypePenguin penguin = new TypePenguin();
		System.out.println("-----请选择企鹅的品种:-----");
		System.out.println("1.很帅气的Q仔");
		System.out.println("2.很美腻的Q妹");
		int input = scanner.nextInt();
		if (input == 1) {
			penguin.setName(args);
			penguin.setSex("很帅气的Q仔");
			penguin.setHealthIndex(99);
			penguin.setIntimacy(12);
			penguin.selfIntroduction();
		}else if(input == 2){
			penguin.setName(args);
			penguin.setSex("很美腻的Q妹");
			penguin.setHealthIndex(88);
			penguin.setIntimacy(25);
			penguin.selfIntroduction();
		}
	}

}
