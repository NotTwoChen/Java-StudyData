package inter;


public interface Work {
	
	public static final String name = "张三";
	
	String gender = "男";
	// 接口中的属性
	// 默认都是静态的常量
	// final关键字修饰的变量,不可改变
//				被称为常量
	
	/*
	 * 接口是一个规范,它规范了什么
	 * 就是要写在接口里面
	 * 比如现在的Work接口,我们可以让它
	 * 规范一个叫Work的方法
	 * 
	 * 接口中的方法都是抽象方法
	 */
	
	void work();
	void goHome();
}
