package com.lanou3g.statics;

public class Main {

	public static void main(String[] args) {
		// 直接使用类名.变量名的方式就可以找到静态变量
		int a = T.score;
		System.out.println(a);
		T.score = 200;
		
		T t1 = new T();
		T t2 = new T();
		t1.score = 3000;
		t2 .show();
//		System.out.println(t1);
		
		
//		T.show();
		
	}

}
