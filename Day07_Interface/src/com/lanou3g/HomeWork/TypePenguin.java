package com.lanou3g.HomeWork;

public class TypePenguin extends PetType{
	public void selfIntroduction(){
		System.out.println("----------恭喜您领养宠物成功!!!----------");
		System.out.println("请静心聆听接下来宠物给您的自我介绍:");
		System.out.println("主人主人,俺滴名字叫"+super.getName()+",我很健康哦!\t\r健康值是:"
		+super.getHealthIndex()+"\t\r与主人的亲密度是"+super.getIntimacy()
		+"\t\r性别是"+super.getSex()+".");
	}
}
