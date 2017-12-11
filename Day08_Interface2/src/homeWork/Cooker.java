package homeWork;

public class Cooker extends Person implements UserInter {
	public void onLine1() {
		System.out.println(getName() + "炒菜的时候喜欢颠勺!");
	}
	public void onLine() {
		System.out.println(getName() + "准备食材做烦了!");
		onLine1();
	}
	public void offLine() {
		System.out.println(getName() + "吃饱喝足美滋滋!");
	}
}
