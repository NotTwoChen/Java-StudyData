package homeWork;
public class Worker extends Person implements UserInter {
	public void onLine1() {
		System.out.println(getName() + "嫌弃工资太低决定罢工!");
	}
	public void onLine() {
		System.out.println(getName() + "开始干活了!");
		onLine1();
	}
	public void offLine() {
		System.out.println(getName() + "干完回家了!");
	}
}
