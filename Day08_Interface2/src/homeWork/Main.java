package homeWork;
import java.util.Scanner;
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		while(true) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1.注册/2.登录");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			scanner.nextLine();
			System.out.println("请输入用户昵称:");
			String name = scanner.nextLine();
			System.out.println("请输入用户名:");
			String username = scanner.nextLine();
			System.out.println("请输入用户密码:");
			String password = scanner.nextLine();
			System.out.println("请选择用户职业:");
			System.out.println("1.Worker/2.Doctor/3.Cooker/4.Boss");
			int input = scanner.nextInt();
			Person person;
			switch (input) {
			case 1:
				person = new Worker();
				person.add(name, username, password, "Worker");
				UserOperate.register(person);
				break;
			case 2:
				person = new Doctor();
				person.add(name, username, password, "Doctor");
				UserOperate.register(person);
				break;
			case 3:
				person = new Cooker();
				person.add(name, username, password, "Cooker");
				UserOperate.register(person);
				break;
			case 4:
				person = new Boss();
				person.add(name, username, password, "Boss");
				UserOperate.register(person);
			default:
				break;
			}
			break;
		case 2:
			scanner.nextLine();
			System.out.println("请输入用户名:");
			String username1 = scanner.nextLine();
			System.out.println("请输入密码:");
			String password1 = scanner.nextLine();
			UserInter ui = UserOperate.login(username1, password1);
			if (ui != null) {
				Person person1 = (Person) ui;
				System.out.println("是否开始工作:1.是/2.否");
				int input1 = scanner.nextInt();
				switch (input1) {
				case 1:
					person1.onLine();
					break;
				case 2:
					person1.offLine();
					break;
				default:
					System.out.println("输入错误!!!");
					break;
				}
			}
			break;
		default:
			break;
		}
		
		}
	}
	
}
