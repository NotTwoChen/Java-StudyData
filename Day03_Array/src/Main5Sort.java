import java.util.Arrays;
import java.util.Scanner;

public class Main5Sort {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*
		 * ����һ������,�������ܳɼ�
		 * Ҫ�������˵ĳɼ�,���Գ���Ϊ5
		 * 
		 */
		
		int[] score = new int[5];
		int max = 0;
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < score.length; i++) {
			System.out.println("��"+(i+1)+"���ɼ�:");
			score[i] = scanner.nextInt();
			if (score[i] > max) {
				max = score[i];
			}
		}
		// �������������,�̶�д��
		Arrays.sort(score);
		
		System.out.println(Arrays.toString(score));
		System.out.println("�ɼ���ߵ���:"+max);
	}
}
 