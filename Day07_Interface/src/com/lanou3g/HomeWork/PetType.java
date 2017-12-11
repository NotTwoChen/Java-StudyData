package com.lanou3g.HomeWork;


public class PetType {
	// 品种
	private String Variety;
	// 名字
	private String name;
	// 健康值
	private int HealthIndex;
	// 亲密度
	private int Intimacy;
	// 性别
	private String sex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVariety() {
		return Variety;
	}
	public void setVariety(String variety) {
		Variety = variety;
	}
	public int getHealthIndex() {
		return HealthIndex;
	}
	public void setHealthIndex(int healthIndex) {
		HealthIndex = healthIndex;
	}
	public int getIntimacy() {
		return Intimacy;
	}
	public void setIntimacy(int intimacy) {
		Intimacy = intimacy;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
