import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("��������Ŀ��Գɼ�");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		if (input > 60 ) {
			System.out.println("���Խ����½׶�ѧϰ");
		}else {
			System.out.println("��Ҫ����ѧϰ");
		}
		
		
		// ��Ҫִ�е����ֻ��һ��ʱ
		// if��������Բ�д{}
		if (input < 60) 
			System.out.println("GG");
		
		// ���ɼ�����80����С��100��ʱ��
		// �����{}��ִ�����
		// ͬʱ������ִ��
		
		
		// && �� &
		// && : ������ж�����������ʱ,�����ж��Ҳ�����
		// & : ������ж�����������ʱ,��Ȼ���ж��Ҳ�����
		if (--input > 80 && --input <100) {
			
			System.out.println("���ϲ���Ŷ");
		}System.out.println(input);
		
		
		// || �� |
		if (input > 60 || input < 90) {
			// ���ұ��ʽ,ֻҪ��һ��Ϊtrue
			// ��ôif�жϵĽ������true
			// || �� | ������
			// || ������Ϊtrue,�򲻻��ж��Ҳ�
			// | ���������ʲô,�����ж��Ҳ�
			
			System.out.println("һ�����");
		}
		
		
		// ! : ��
		// !true = false
		// !false = true
		if (!(input<60)) {
			System.out.println("�д�������С����");
		}
		
		// ��ν�������������ֵ
//		int a = 10 ;
//		int b = 20 ;
		
		// ��һ�ַ���:
		// 1.����һ���µı���c
		// 2.��a��ֵ��ֵ��c
		// 3.��b��ֵ��ֵ��a
		// 4.��c��ֵ��ֵ��b
		
		// �ڶ��ַ���
		// ��ʹ�õ���������,ֱ��ʹ�üӼ���
		
		// a = a + b;
		// b = a - b;
		// a = a - b;
		
		// �����ַ���
		// ��ʹ�õ���������,ʹ�����^
		// һ���������һ��������,������������
		/*
		 *  ����������
		 *  ��һ����1,������1
		 *  
		 *  ^������������
		 *  ���߲����,��Ϊ1,�����Ϊ0
		 *  Ҳ���ǲ�ͬʱΪ1��0
		 */
		// a = a ^ b ;
		// b = a ^ b ;
		// a = a ^ b ;
//		main(args);
	}
}
