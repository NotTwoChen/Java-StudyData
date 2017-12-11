import java.util.Arrays;
import java.util.Scanner;


public class Rhombus {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 1.��ӡ���е�ˮ�ɻ���
		System.out.println("��λ������ˮ�ɻ���:");
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
		
		
		// 2.��������Ԫ�ص�:���ֵ,��Сֵ,ƽ��ֵ��Ԫ��֮��
		// ����һ�����鲢���������鳤��
		Scanner scanner = new Scanner(System.in);
		System.out.println("���벢�������鳤��");
		int input = 5;
//				scanner.nextInt();
		int[] array = new int[input];
		// �������ڴ������е�Ԫ��
		for (int i = 0; i < array.length; i++) {
			System.out.println("�����"+(i+1)+"λ����Ԫ��");
			array[i] = i;
//					scanner.nextInt();
		}
		// �����ֵ
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}System.out.println("�������ֵΪ:"+max);
		// ����Сֵ
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}System.out.println("������СֵΪ:"+min);
		
		// ��Ԫ��֮��
		int num = 0 ;
		for (int i = 0; i < array.length; i++) {
			num += array[i];
		}System.out.println("����Ԫ��֮��Ϊ:"+num);
		
		// ��ƽ����
		System.out.println("����Ԫ�ص�ƽ����Ϊ:"+num/input);
		
		
		// 3.��forѭ����Ƕ�״�ӡ����
		System.out.println("������������ɹؼ���:");
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
		
		
		
		// 5.��ӡ�Զ���߳��������μ���Խ���
		System.out.println("�����������εı߳�:11");
		
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
		
		// 6.��ӡ�Զ���뾶��Բ��
		System.out.println("������Բ�εİ뾶:5");
		int radius = 10;
//				scanner.nextInt()*2;
		for (int i = 0; i < radius; i++) {
			for (int j = 0; j < radius; j++) {
				System.out.print(" *");
			}System.out.println();
		}
		System.out.println("ʵ��");
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
		
		
		
		System.out.println("Բ��");
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
		
		// 4.��main�����ж�����������:�˺ţ����룬�û��ǳ�
				// ��ע��Ϊ�ʺ������û��ǳƽ�����һ���洢��λ��
		int id [] = new int[1];
		int password [] = new int [1];
		String name [] = new String[1];
		Scanner entry = new Scanner(System.in);
		int i1 = 0;
		while(true) {
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
				}if (id[i1] != 0) {
					i1++;
				}int b = 0 ;
				for (int j = 0; j < id.length; j++) {
					for (int j2 = 0; j2 < id.length; j2++) 
						if (id[j2] == idEnroll) {
							System.out.println("���˺��Ѵ���");
							j = id.length;
							b = 1;
							break;
						}if (b == 1) {
							continue;
						}if (id[j] != idEnroll) {
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
		System.out.println("��ӭ����java����");
	}
}