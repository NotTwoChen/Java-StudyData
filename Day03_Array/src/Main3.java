import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int[] scores = {98,99,94,96,90};
		/*
		 * scores ���Ǳ�ʶ��,��������������
		 * int��ʾ��������п���װ�ص�����
		 * int[]��ʾ������������
		 * 
		 * {}�е�����,�������������
		 * 98:�����е�Ԫ��,���������е�����
		 * �±�:
		 * 		Ԫ���������е�λ��
		 * 		��0��ʼ����
		 * ���������һ��Ԫ�ص��±꼴Ϊ����ĳ���-1
		 */
		
		// ȡ���������±�Ϊ0��Ԫ��
		// ��ֵ��һ������b
		int b = scores[0];
		System.out.println(b);
		
		// ��������ĵڶ��ַ�ʽ
		int[] d = new int[3];
		
		Scanner input = new Scanner(System.in);
		// d.length:��ʾ����d�ĳ���
		for (int i = 0; i < d.length; i++) {
			// ���������������ֵ,��ֵ��r
//			int r = input.nextInt();
			
			// ��r��ֵ��ֵ�������е�iλ�õ�Ԫ��
//			d[i] = r;
			System.out.println("��¼���"+i+"���ɼ�");
			d[i] = input.nextInt();
		}// �̶�д��,����ֱ�����d������
		System.out.println(Arrays.toString(d));
//		d[4] = 100;
	}
}
