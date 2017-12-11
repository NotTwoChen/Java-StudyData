
public class HomeWork {
	public static void main(String[] args) {
		Courier courier = new Courier();
		courier.name = "赵一";
		courier.work = "快递员";
		courier.sex = "男";
		courier.age = 35;
		courier.Delivery();
		courier.WorkTime(11);
		System.out.println(courier.Salary());
		System.out.println(courier.DeliveryGoods(20));
		SalesPerson salesPerson = new SalesPerson();
		salesPerson.name = "钱二";
		salesPerson.work = "售货员";
		salesPerson.sex = "女";
		salesPerson.age = 25;
		salesPerson.Salesclerk();
		salesPerson.WorkTime(12);
		System.out.println(salesPerson.Shop());
		System.out.println(salesPerson.Assistant(100));
	}
}
class people{
	
	/*
	 * 四个类四个属性
	 * 姓名/工作/性别/年龄
	 */
	String name;
	String work;
	String sex;
	int age;
	/**
	 * 	不带参数不带返回值:  (null) void
		不带参数带返回值:(null) 类型
		带参数不带返回值:(参数)void
		带参数带返回值:(参数)类型
	 */
	
}
// 快递员
class Courier extends people{
	public void Delivery(){
		System.out.println(name+"是一个"+age+"岁的"+sex+"子,职业是"+work);
	}
	public String Salary() {
		return name + "很喜欢现在的身份";
	}
	public void WorkTime(int time) {
		System.out.println(name+"已经工作了"+time+"年了");
	}
	public String DeliveryGoods(int goods) {
		return name + "今天已经送了" + goods + "件货了";
	}
}
// 售货员
class SalesPerson extends people{
	public void Salesclerk() {
		System.out.println(name+"是一个"+age+"岁的"+sex+"子,职业是"+work);
	}
	public String Shop() {
		return name + "很讨厌现在的工作";
	}
	public void WorkTime(int time) {
		System.out.println(name+"每天都要做"+time+"个小时的工作");
	}
	public String Assistant(int guest) {
		return name + "今天至少接待了近" + guest + "个客人";
	}
}
// 学生
class BigStudent extends people{
	 
}
// 教师
class teacher extends people{
	
}
