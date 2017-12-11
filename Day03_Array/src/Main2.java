import java.util.Scanner;

public class Main2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		/**
		 * 有四个班级,每个班级有五名同学
		 * 所以每个班级都要循环一次
		 * 在这个班级的循环中
		 * 再循环接受每名同学的成绩
		 */
		
		
		// 第一层循环,每次循环都表示一个班级
		for(int i = 1; i < 5; i++ ) {
			// 用于存储班级成绩的变量
			int num = 0;
			// 第二层循环,每次循环都表示要接受一个学生的成绩
			for (int j = 1; j < 6; j++) {
				// 当两层循环都执行完毕时
				// 下面的输出语句执行了多少次?
				
				System.out.println("请输入第"+i+"班的第"+j+"位同学的成绩:");
				int score = input.nextInt();
				
				// 怎么能把接收到的成绩保存起来,用于求班级平均分
				num += score;
			}
			System.out.println("第"+i+"班的平均分是:"+num/5);
		}
	}
}
