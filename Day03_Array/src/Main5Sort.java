import java.util.Arrays;
import java.util.Scanner;

public class Main5Sort {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*
		 * 创建一个数组,用来接受成绩
		 * 要接受五人的成绩,所以长度为5
		 * 
		 */
		
		int[] score = new int[5];
		int max = 0;
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < score.length; i++) {
			System.out.println("第"+(i+1)+"个成绩:");
			score[i] = scanner.nextInt();
			if (score[i] > max) {
				max = score[i];
			}
		}
		// 对数组进行排序,固定写法
		Arrays.sort(score);
		
		System.out.println(Arrays.toString(score));
		System.out.println("成绩最高的是:"+max);
	}
}
 