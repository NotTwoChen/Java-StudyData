
public class liStudent {
	String name;
	String school;
	int id;
	
	public void play() {
		System.out.println(name + "玩游戏去了");
		
	}
	
	public void goToStudy() {
		System.out.println(name + "去上学了,学校是" + school);
		
	}
	
	/*
	 *  public	权限修饰符
	 *  void	返回值类型
	 *  show	方法名
	 *  (String str)	参数列表, 是可以有多个参数的
	 *  			String 是参数的类型
	 *  				调用方法是,需要传入对象类型的内容
	 *  			str		是参数的名字
	 *  				是任意的,想怎么写就怎么写
	 *  				但是要见名知意
	 *  {}	方法体
	 *  		当这个方法被调用时,要执行的代码
	 */
	public void show (String str) {
		
	}
	
	public void buyOutFood(int money) {
		System.out.println("拿着老师的钱"+ money+ "去打游戏了");
	}
	
	// 让这个学生具备一个加法运算的能力
	
	public void addOperation(int a , int b) {
		System.out.println(name+"把"+a+"+"+b+"="+(a+b)+"算出来了");
	}
	
	// public 后面的这个String
	// 表示返回值的类型是String ,是字符串
	public String hot (String food) {
		return "加热了的"+ food;
	}
}
