package homeWork;

public class Boss extends Person implements UserInter {
	public void onLine1() {
		System.out.println(getName() + "难得给大家伙涨了一次工资!");
	}
	public void onLine() {
		System.out.println(getName() + "准备发布企业策划书了!");
		onLine1();
	}
	public void offLine() {
		System.out.println(getName() + "下班下班!");
	}
}
