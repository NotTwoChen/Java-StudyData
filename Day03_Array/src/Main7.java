
public class Main7 {
	public static void main(String[] args) {
		int[] scores = {60,70,80,90,99};
		
		int add = 75;
		
		int[] scores1 = new int[6];
		
		// a.length -1��,iֻ��ȡֵ��3
		for (int i = 0; i < scores1.length; i++) {
//			System.out.println(scores[i]);
			if (i < scores.length-1) {
				if (scores[i] < add && scores[i+1] > add) {
					// �����������,˵��addҪ���ڵ�i+1λ
					scores1[i] = scores[i];
					scores1[i+1] = add;
//					scores1[i+1] = add; 
//					return;
				}
//				else {
					// ����������,�򲻲���add
					// ��scores��ȡ����iλ��ֵ,��ֵ��scores1
					scores1[i] = scores[i];
//				}
			}
			// ���һ��ֱ�Ӹ�ֵ
//			scores1[i] = scores[i];
		}
		for (int i = 0; i < scores1.length; i++) {
			System.out.println(scores1[i]);
		}
	}
}
