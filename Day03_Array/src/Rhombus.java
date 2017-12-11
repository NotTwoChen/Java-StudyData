import java.util.Arrays;
import java.util.Scanner;


public class Rhombus {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 1.打印所有的水仙花数
		System.out.println("三位数所有水仙花数:");
		for (int i = 1; i < 10; i++) {
			int hundredsDigit = i*i*i;
			for (int j = 0; j < 10; j++) {
				int tensDigit = j*j*j;
				for (int j2 = 0; j2 < 10; j2++) {
					int unitsDigit = j2*j2*j2;
					if ((hundredsDigit+tensDigit+unitsDigit) == i*100+j*10+j2) {
						System.out.println(i+""+j+""+j2);
					}
				}
			}
		}
		
		
		// 2.求数组中元素的:最大值,最小值,平均值及元素之和
		// 创建一个数组并赋予它数组长度
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入并定义数组长度");
		int input = 5;
//				scanner.nextInt();
		int[] array = new int[input];
		// 在数组内创建所有的元素
		for (int i = 0; i < array.length; i++) {
			System.out.println("输入第"+(i+1)+"位数组元素");
			array[i] = i;
//					scanner.nextInt();
		}
		// 求最大值
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}System.out.println("数组最大值为:"+max);
		// 求最小值
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}System.out.println("数组最小值为:"+min);
		
		// 求元素之和
		int num = 0 ;
		for (int i = 0; i < array.length; i++) {
			num += array[i];
		}System.out.println("数组元素之和为:"+num);
		
		// 求平均数
		System.out.println("数组元素的平均数为:"+num/input);
		
		
		// 3.用for循环的嵌套打印菱形
		System.out.println("请输入菱形组成关键数:");
		int plies = scanner.nextInt();
		for (int i = 0; i < plies; i++) {
			for (int k = i; k < plies+1; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			for (int l = 0; l < i; l++) {
				System.out.print("*");
			}System.out.println();
		}
		for (int n = 0; n < plies+1; n++) {
			for (int o = 0; o < n+1; o++) {
				System.out.print(" ");
			}
			for (int p = n; p < plies+1; p++) {
				System.out.print("*");
			}
			for (int q = n; q < plies; q++) {
				System.out.print("*");
			}System.out.println();
		}
		
		
		
		// 5.打印自定义边长的正方形及其对角线
		System.out.println("请输入正方形的边长:11");
		
		int length = 11;
//				scanner.nextInt();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i>0&&j>0&&i<length-1&&j<length-1) {
					if (i == j ||  i == length - j - 1) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}else {
				System.out.print("*");
				}
			}
			System.out.println();
		}
		
		// 6.打印自定义半径的圆形
		System.out.println("请输入圆形的半径:5");
		int radius = 10;
//				scanner.nextInt()*2;
		for (int i = 0; i < radius; i++) {
			for (int j = 0; j < radius; j++) {
				System.out.print(" *");
			}System.out.println();
		}
		System.out.println("实例");
		System.out.println("0 1 2 3 4 5 6 7 8 9 0");
		System.out.println("1     +         +    ");
		System.out.println("2   +   +     +   +  ");
		System.out.println("3 +       + +       +");
		System.out.println("4 +                 +");
		System.out.println("5 +                 +");
		System.out.println("6 +                 +");
		System.out.println("7   +             +  ");
		System.out.println("8     +         +    ");
		System.out.println("9       +     +      ");
		System.out.println("0         + +        ");
		
		
		
		System.out.println("圆形");
		int r = 10;
		for (int y = 0; y <= 2 * r; y += 2) {
			long x = Math.round(r - Math.sqrt(2 * r * y - y * y));
			long longLength = 2 * (r - x);

			for (int i = 0; i <= x; i++) {
				System.out.print(' ');
			}
			System.out.print('*');

			for (int j = 0; j <= longLength; j++) {
				System.out.print(' ');
			}
			System.out.println('*');
		}
		System.out.println("-----------------");
		System.out.println();
		System.out.println();
		System.out.println();
		
		// 4.在main方法中定义三个变量:账号，密码，用户昵称
				// 先注册为帐号密码用户昵称建立有一个存储的位置
		int id [] = new int[1];
		int password [] = new int [1];
		String name [] = new String[1];
		Scanner entry = new Scanner(System.in);
		int i1 = 0;
		while(true) {
			System.out.println("----------1.注册----------");
			System.out.println("----------2.登录----------");
			int option = entry.nextInt();
			switch (option) {
			case 1:
				System.out.println("⑴注册账号:");
				int idEnroll = entry.nextInt();
				if (id[id.length-1] != 0 || password[password.length-1] != 0 || name[name.length-1] != null) {
					id = Arrays.copyOf(id, id.length+1);
					password = Arrays.copyOf(password,password.length+1);
					name = Arrays.copyOf(name, name.length+1);
				}if (id[i1] != 0) {
					i1++;
				}int b = 0 ;
				for (int j = 0; j < id.length; j++) {
					for (int j2 = 0; j2 < id.length; j2++) 
						if (id[j2] == idEnroll) {
							System.out.println("该账号已存在");
							j = id.length;
							b = 1;
							break;
						}if (b == 1) {
							continue;
						}if (id[j] != idEnroll) {
							System.out.println("⑵注册密码:");
							int passwordEnroll = entry.nextInt();
							System.out.println("⑶确认密码:");
							int passwordVerify = entry.nextInt();
							entry.nextLine();
							System.out.println("⑷注册昵称");
							String nameEnroll = entry.nextLine();
							if (passwordVerify == passwordEnroll) {
								id[i1] = idEnroll;
								password[i1] = passwordEnroll;
								name[i1] = nameEnroll;
								System.out.println("!!!注册成功!!!");
								break;
							}else {
								System.out.println("!!!密码不一致,注册失败!!!");
							}
							j = id.length;}}
				break;
			case 2:
				System.out.println("⑴登录账号:");
				int idEnter = entry.nextInt();
				for (int i2 = 0; i2 < id.length; i2++) {
					if (id[i2] != idEnter && i2 == id.length-1) {
						System.out.println("该账号不存在");
					}if(id[i2] == idEnter) {
						System.out.println("⑵登录密码:");
						int passwordEnter =entry.nextInt();
						if (passwordEnter != password[i2]) {
							System.out.println("!!!密码输入错误!!!");
						}else {
							System.out.println("!!!登录成功!!!");
							System.out.println("!!!欢迎"+name[i2]+"登录系统!!!");
							main1(args);
							}
						}
					}
				break;
			default:
				break;
			}
		}
	}
	public static void main1(String[] args) {
		System.out.println("欢迎来到java世界");
	}
}
