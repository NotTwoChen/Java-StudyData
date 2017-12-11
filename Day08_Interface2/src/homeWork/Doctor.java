package homeWork;

public class Doctor extends Person implements UserInter {
	public void onLine1() {
		System.out.println(getName() + "动手术的时候满头大汗!");
	}
	public void onLine() {
		System.out.println(getName() + "开始问诊了!");
		onLine1();
	}
	public void offLine() {
		System.out.println(getName() + "手术做太多,累晕了!");
	}

}
