
public class Work {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("¡º"+j+"*"+i+"="+i*j+"¡»"+" ");
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
