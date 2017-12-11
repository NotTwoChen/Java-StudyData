package com.lanou3g.change;

public class Main {
	public static void main(String[] args) {
		// 父类的引用指向了子类的对象
		Father fason = new Son();
		
//		fason = new Daughter();
		
		// 父类的引用只能找到父类的方法
		// 找不到子类的独有方法
		fason.eat();
		
//		Son bigSon1 = (Son)fason;
		// 类型转换异常
		
		if (fason instanceof Son) {
			// 如果fason这个引用指向的对象类型为son
			// 那么我们可以进行强制类型转换
			System.out.println("实例运算符编写成功!");
			// ()中写的就是要强制转换的类型
			Son bigSon = (Son) fason;
			bigSon.eat();
			bigSon.WatchTV();
		}
		
		
	}
}
