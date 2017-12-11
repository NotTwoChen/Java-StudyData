import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("请输入你的考试成绩");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		if (input > 60 ) {
			System.out.println("可以进入下阶段学习");
		}else {
			System.out.println("需要重新学习");
		}
		
		
		// 当要执行的语句只有一条时
		// if语句后面可以不写{}
		if (input < 60) 
			System.out.println("GG");
		
		// 当成绩大于80并且小于100的时候
		// 会进入{}中执行语句
		// 同时成立则执行
		
		
		// && 和 &
		// && : 当左侧判断条件不成立时,不会判断右侧条件
		// & : 当左侧判断条件不成立时,依然会判断右侧条件
		if (--input > 80 && --input <100) {
			
			System.out.println("哎呦不错哦");
		}System.out.println(input);
		
		
		// || 和 |
		if (input > 60 || input < 90) {
			// 左右表达式,只要有一个为true
			// 那么if判断的结果就是true
			// || 和 | 的区别
			// || 如果左侧为true,则不会判断右侧
			// | 不管左侧是什么,都会判断右侧
			
			System.out.println("一般般嘛");
		}
		
		
		// ! : 非
		// !true = false
		// !false = true
		if (!(input<60)) {
			System.out.println("有待进步啊小伙子");
		}
		
		// 如何交换两个变量的值
//		int a = 10 ;
//		int b = 20 ;
		
		// 第一种方法:
		// 1.定义一个新的变量c
		// 2.将a的值赋值给c
		// 3.将b的值赋值给a
		// 4.将c的值赋值给b
		
		// 第二种方法
		// 不使用第三方变量,直接使用加减法
		
		// a = a + b;
		// b = a - b;
		// a = a - b;
		
		// 第三种方法
		// 不使用第三方变量,使用异或^
		// 一个数异或另一个数两次,结果还是这个数
		/*
		 *  操作二进制
		 *  有一个是1,则结果是1
		 *  
		 *  ^异或操作二进制
		 *  两者不相等,则为1,相等则为0
		 *  也就是不同时为1或0
		 */
		// a = a ^ b ;
		// b = a ^ b ;
		// a = a ^ b ;
//		main(args);
	}
}
