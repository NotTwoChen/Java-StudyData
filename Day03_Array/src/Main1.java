import java.util.Scanner;

public class Main1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入数字:666");
//		int input = 666; 
//				
////				scanner.nextInt();
//		System.out.println("运算表:");
//		// 将输入进来 的数值,作为循环判断的条件
//		for (int i = 0; i <= input/2; i++) {
//			System.out.println(i + "+" + (input-i) + "=" + input);
//			
//		}
//		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入成绩录入的人数");
		int input = scanner.nextInt();
		int people = input;
		int peoplex = 0; 
		for (int i = 1; i <= people; i++) {
			System.out.println("请输入第"+i+"个学生的考试成绩");
			int score = scanner.nextInt();
			if (score > 80) {
				peoplex++;
			}else {
				continue;
			}
		}
		System.out.println("成绩及格的人数为"+peoplex);
	}
}
