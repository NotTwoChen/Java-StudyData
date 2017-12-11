import java.util.Scanner;

public class Main2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int i = 100;
		/*
		 * while循环
		 * 先判断括号中的内容,是否为true
		 * 如果为true则执行
		 * 大括号里面的内容,然后再判断括号里面的例如是否为true
		 * 如果...一遍遍
		 * 当括号内容为false时
		 * while循环停止
		 */
		while (i<50) {
			i++;
			System.out.println(i);
			if (i>25) {
				break;
			}
		}
		
		int progress = 1;
		do {
			progress+=2;
			System.out.println(progress);
		} while (progress < 10);
		
		/*
		 * do-while 与 while 的区别
		 * do-while 是先执行一次循环体,然后再判断
		 * while是先判断然后再执行循环体
		 */
		
		int a = 1;
		while(a <= 1) {
			System.out.println(a +".好好学习,天天向上");
			a++;
		}
		
		int b = 1;
		do {
			System.out.println(b + ".好好学习天天向上");
			b++;
		} while (b<=1);
		
		
		for (int j = 1;// 设置初识条件
				j <= 1;// 循环条件
				j++)// 循环增量
		{ // 循环体
			System.out.println(j + ".好好向上天天学习");
		}
		
		
		// 本质一样:死循环
//		while (true) {
//			
//		}
//		for (;;) {
//			
//		}
		
		int f = 0;
		for (; f < 10; f++) {
			
		}
		for (; f < 10; f+=5) {
			
		}
		
		// 固定格式,就是一个工具
		
		// 下面这句话,会得到控制台输入的内容
		// 我们建立一个变量去接收得到的内容
//		String c = scanner.nextLine();
//		System.out.println(c);
		
		/*
		 * 
		 * import
		 * scanner
		 * console
		 * debug
		 */
		Scanner scanner = new Scanner(System.in);
		int e = 0;
		for (int q = 1; q <= 5; q++) {
			System.out.println("请输入第"+q+"门课的成绩");
			int A = scanner.nextInt();
			e = e + A;
			System.out.println("-----第"+q+"门课的成绩是"+A+"分");
		}
		System.out.println("五门课的平均成绩是"+e/5+"分");
	}
}
