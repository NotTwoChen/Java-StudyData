import java.util.Arrays;
import java.util.Scanner;

public class RegisterAndLogin{
	@SuppressWarnings("resource")
	public static void main(String[] args){
		int id [] = new int[1];
		int password [] = new int [1];
		String name [] = new String[1];
		Scanner entry = new Scanner(System.in);
		int i1 = 0;
		while(true) {
			System.out.println(Arrays.toString(id));
			System.out.println(Arrays.toString(password));
			System.out.println(Arrays.toString(name));
			System.out.println("----------1.ע��----------");
			System.out.println("----------2.��¼----------");
			int option = entry.nextInt();
			switch (option) {
			case 1:
				System.out.println("��ע���˺�:");
				int idEnroll = entry.nextInt();
				if (id[id.length-1] != 0 || password[password.length-1] != 0 || name[name.length-1] != null) {
					id = Arrays.copyOf(id, id.length+1);
					password = Arrays.copyOf(password,password.length+1);
					name = Arrays.copyOf(name, name.length+1);
				}
				if (id[i1] != 0) {
					i1++;
				}
				int b = 0 ;
				for (int j = 0; j < id.length; j++) {
					for (int j2 = 0; j2 < id.length; j2++) 
						if (id[j2] == idEnroll) {
							System.out.println("���˺��Ѵ���");
							j = id.length;
							b = 1;
							break;
						}
						if (b == 1) {
							continue;
						}
						if (id[j] != idEnroll) {
							System.out.println("��ע������:");
							int passwordEnroll = entry.nextInt();
							System.out.println("��ȷ������:");
							int passwordVerify = entry.nextInt();
							entry.nextLine();
							System.out.println("��ע���ǳ�");
							String nameEnroll = entry.nextLine();
							if (passwordVerify == passwordEnroll) {
								id[i1] = idEnroll;
								password[i1] = passwordEnroll;
								name[i1] = nameEnroll;
								System.out.println("!!!ע��ɹ�!!!");
								break;
							}else {
								System.out.println("!!!���벻һ��,ע��ʧ��!!!");
							}
							j = id.length;}}
				break;
			case 2:
				System.out.println("�ŵ�¼�˺�:");
				int idEnter = entry.nextInt();
				for (int i2 = 0; i2 < id.length; i2++) {
					if (id[i2] != idEnter && i2 == id.length-1) {
						System.out.println("���˺Ų�����");
					}if(id[i2] == idEnter) {
						System.out.println("�Ƶ�¼����:");
						int passwordEnter =entry.nextInt();
						if (passwordEnter != password[i2]) {
							System.out.println("!!!�����������!!!");
						}else {
							System.out.println("!!!��¼�ɹ�!!!");
							System.out.println("!!!��ӭ"+name[i2]+"��¼ϵͳ!!!");
							break;
							}
						}
					}
				break;
			default:
				System.out.println("!!!�������,����������!!!");
				break;
			}
		}
	}
}

