import java.util.Scanner;

public class Main1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("����������:666");
//		int input = 666; 
//				
////				scanner.nextInt();
//		System.out.println("�����:");
//		// ��������� ����ֵ,��Ϊѭ���жϵ�����
//		for (int i = 0; i <= input/2; i++) {
//			System.out.println(i + "+" + (input-i) + "=" + input);
//			
//		}
//		
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ɼ�¼�������");
		int input = scanner.nextInt();
		int people = input;
		int peoplex = 0; 
		for (int i = 1; i <= people; i++) {
			System.out.println("�������"+i+"��ѧ���Ŀ��Գɼ�");
			int score = scanner.nextInt();
			if (score > 80) {
				peoplex++;
			}else {
				continue;
			}
		}
		System.out.println("�ɼ����������Ϊ"+peoplex);
	}
}
