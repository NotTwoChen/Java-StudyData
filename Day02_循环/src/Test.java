import java.util.Scanner;

public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("请输入韩嫣参加计算机编程大赛获得的名次");
		String input = scanner.nextLine();
		switch (input) {
		case "1":
			System.out.println("参加麻省理工大学组织的一个月夏令营");
			break;
		case "2":
			System.out.println("奖励惠普笔记本电脑一部");
			break;
		case "3":
			System.out.println("奖励移动硬盘一个");
			break;
		case "4":
			main1(args);
			break;
		default:
			System.out.println("你一个失败者还有脸提奖励?");
			break;
		}
		}
	}
	
	@SuppressWarnings("resource")
	public static void main1(String[] args) {
		System.out.println("请输入韩嫣参加计算机编程大赛获得的名次");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		if (input ==  1) {
			System.out.println("参加麻省理工大学组织的一个月夏令营");
		}else if (input == 2) {
			System.out.println("奖励惠普笔记本电脑一部");
		}else if (input == 3) {
			System.out.println("奖励移动硬盘一个");
		}else {
			System.out.println("没有任何奖励");
		}
	}
}
