
public class Main7 {
	public static void main(String[] args) {
		int[] scores = {60,70,80,90,99};
		
		int add = 75;
		
		int[] scores1 = new int[6];
		
		// a.length -1后,i只能取值到3
		for (int i = 0; i < scores1.length; i++) {
//			System.out.println(scores[i]);
			if (i < scores.length-1) {
				if (scores[i] < add && scores[i+1] > add) {
					// 如果满足条件,说明add要放在第i+1位
					scores1[i] = scores[i];
					scores1[i+1] = add;
//					scores1[i+1] = add; 
//					return;
				}
//				else {
					// 不满足条件,则不插入add
					// 从scores中取出第i位的值,赋值给scores1
					scores1[i] = scores[i];
//				}
			}
			// 最后一个直接给值
//			scores1[i] = scores[i];
		}
		for (int i = 0; i < scores1.length; i++) {
			System.out.println(scores1[i]);
		}
	}
}
