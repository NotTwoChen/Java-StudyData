import java.util.Scanner;

public class TenMoney {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 10亿元每天花一半,可以花几天
		System.out.println("*.");
		long money = 1000000000;
		// i即为天数
		for (int i = 1; money != 0; i++) {
			// 每天花一半
			money /=2;
			// 打印天数和花钱数
			System.out.println("第"+i+"天花了"+money+"元");
		}
		
		
		// 1.打印
		System.out.println("1.");
		System.out.println("********************");
		System.out.println("  ***     JAVA     ***");
		System.out.println("    ********************");
		
		// 2.189元如何使用最少的100/50/20/10/5/1元组成,并输出各面值钱币的张数
		System.out.println("2.");
		int a = 488,b = 100,c = 50,d = 20,e = 10,f = 5,g = 1;
		for (int i = 1; a >= b ; i++) {
			a -= b;
			if (a < b) {
				System.out.println("面值100的张数为:"+i);
			}
		}
		for (int j = 1; a >= c ; j++) {
			a -= c;
			if (a < c) {
				System.out.println("面值50的张数为:"+j);
			}
		}
		for (int k = 1; a >= d ; k++) {
			a -= d;
			if (a < d) {
			System.out.println("面值20的张数为:"+k);
			}
		}
		for (int l = 1; a >= e ; l++) {
			a -= e;
			if (a < e) {
			System.out.println("面值10的张数为:"+l);
			}
		}
		for (int m = 1; a >= f; m++) {
			a -= f;
			if (a < f) {
			System.out.println("面值5的张数为:"+m);
			}
		}
		for (int n = 1; a >= g; n++) {
			a -= g;
			if (a == 0) {
				System.out.println("面值1的张数为:"+n);
			}						
		}
		int aa = 488,bb = 100,cc = 50,dd = 20,ee = 10,ff = 5,gg = 1;
		// 第二种做法
		int ab = aa/bb;
		int ac = aa%bb/cc;
		int ad = aa%bb%cc/dd;
		int ae = aa%bb%cc%dd/ee;
		int af = aa%bb%cc%dd%ee/ff;
		int ag = aa%bb%cc%dd%ee%ff/gg;
		System.out.println(ab+"+"+ac+"+"+ad+"+"+ae+"+"+af+"+"+ag);
		
		// 3.现有一个整数,判断是奇数还是偶数
		System.out.println("3.");
		new Scanner(System.in);
//		while(true) {
		System.out.println("请输入你要进行判断的整数");
		int input = 2;
//				scanner.nextInt();
		if (input%2 == 0) {
			System.out.println(input+"为偶数");
		}else if (input%2 != 0) {
			System.out.println(input+"为奇数");
		}else {
			System.out.println(input+"为非奇非偶的整数");
//		}
		}
		
		// 4.铁路托运行李规定:行李重不超过50公斤的,托运费算0.15元每公斤计算
		// 如果超过50公斤,超出部分每公斤加收0.1元
		System.out.println("4.");
		// 重量的定义
		System.out.println("请输入你要托运的行李重量");
		int weigh = 55;
//				scanner.nextInt();
		// 托运费的定义
		double haulage;
		if (weigh <= 50) {
			haulage = 0.15*weigh;
			System.out.println("托运费为:"+haulage);
		}else if(weigh > 50) {
			haulage = 0.15*50 + 0.1*(weigh-50);
			System.out.println("托运费为:"+haulage);
		}
		
		// 5.给定一个年份,判定是否为闰年
		// 1.能被4整除而不能被100整除
		// 2.能被400整除
		System.out.println("5.");
		System.out.println("请输入你要判断的年份");
		int year = 1956;
//				scanner.nextInt();
		if (year % 4 == 0 && year % 100 != 0) {
			System.out.println(year+"年为闰年");
		}else if (year % 400 == 0) {
			System.out.println(year+"年为闰年");
		}
		else {
			System.out.println(year+"年不为闰年");
		}
		
		// 6.二进制的负数如何计算出来的
		// 反码补码
		/**
		 * 十进制数字:5
		 * 二进制数字:101
		 * 源码:0000 0101
		 * 反码:1111 1010
		 * 补码:1111 1011
		 * 
		 * 二进制的十进制负数:1110 0111
		 * 源码:	1110 0111
		 * 反码:	0001 1000
		 * 反补码:0001 0111
		 * 二进制数字:10111
		 * 十进制数字:23
		 * 
		 */
	}
}
