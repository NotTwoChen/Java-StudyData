package test;

public class Main {
	public static void main(String[] args) {
		Student student = new Student();
		Student student2 = new Student();
//		student.name = "张三";
		// 通过getName方法
		// 拿到student对象的name属性
		String name = student.getName();
		// 当执行setName方法时,就将这个值传给了参数列表中的参数n
		name = student2.getName();
		System.out.println("改之前"+name);
		student2.setName("关联值");
		name = student2.getName();
		System.out.println("改之后"+name);
		
		// 得到sad方法执行的结果
		// 把这个结果赋值给了result这个变量
//		String result = student.sad();
		// 输出
//		System.out.println(result);
	}
}
