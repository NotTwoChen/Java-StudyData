import java.util.Scanner;

public class Main2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		/**
		 * ���ĸ��༶,ÿ���༶������ͬѧ
		 * ����ÿ���༶��Ҫѭ��һ��
		 * ������༶��ѭ����
		 * ��ѭ������ÿ��ͬѧ�ĳɼ�
		 */
		
		
		// ��һ��ѭ��,ÿ��ѭ������ʾһ���༶
		for(int i = 1; i < 5; i++ ) {
			// ���ڴ洢�༶�ɼ��ı���
			int num = 0;
			// �ڶ���ѭ��,ÿ��ѭ������ʾҪ����һ��ѧ���ĳɼ�
			for (int j = 1; j < 6; j++) {
				// ������ѭ����ִ�����ʱ
				// �����������ִ���˶��ٴ�?
				
				System.out.println("�������"+i+"��ĵ�"+j+"λͬѧ�ĳɼ�:");
				int score = input.nextInt();
				
				// ��ô�ܰѽ��յ��ĳɼ���������,������༶ƽ����
				num += score;
			}
			System.out.println("��"+i+"���ƽ������:"+num/5);
		}
	}
}
