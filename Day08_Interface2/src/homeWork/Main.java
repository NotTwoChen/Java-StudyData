package homeWork;
import java.util.Scanner;
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		while(true) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1.ע��/2.��¼");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			scanner.nextLine();
			System.out.println("�������û��ǳ�:");
			String name = scanner.nextLine();
			System.out.println("�������û���:");
			String username = scanner.nextLine();
			System.out.println("�������û�����:");
			String password = scanner.nextLine();
			System.out.println("��ѡ���û�ְҵ:");
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
			System.out.println("�������û���:");
			String username1 = scanner.nextLine();
			System.out.println("����������:");
			String password1 = scanner.nextLine();
			UserInter ui = UserOperate.login(username1, password1);
			if (ui != null) {
				Person person1 = (Person) ui;
				System.out.println("�Ƿ�ʼ����:1.��/2.��");
				int input1 = scanner.nextInt();
				switch (input1) {
				case 1:
					person1.onLine();
					break;
				case 2:
					person1.offLine();
					break;
				default:
					System.out.println("�������!!!");
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