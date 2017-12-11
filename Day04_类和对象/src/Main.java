
public class Main {
	public static void main(String[] args) {
		// 这就是创建对象的过程
		// 什么是对象
//		Car car = new Car();
		// 这里是将car的地址传给了car2
//		Car car2 = new Car();
		// Car就是
		// car就是对象
		// 是根据Car这个类创建出来的对象
//		car.showInfo();
//		System.out.println(car == car2);
		
		Father father = new Father();
		Mother mother = new Mother();
		Child child = new Child();
		father.name = "赵钱孙李爹";                              
		father.money = 20000;
		father.age = 30;
		mother.name = "赵钱孙李娘";
		mother.repast = "红烧肉";
		mother.age = 28;
		child.name = "赵钱孙李";
		child.school = "清大北华";
		child.age = 18;
		child.object = "周吴郑王";
		
		father.showInfo();
		mother.showInfo();
		child.showInfo();
	}
	
}
