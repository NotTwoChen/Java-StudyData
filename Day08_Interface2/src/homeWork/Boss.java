package homeWork;

public class Boss extends Person implements UserInter {
	public void onLine1() {
		System.out.println(getName() + "�ѵø���һ�����һ�ι���!");
	}
	public void onLine() {
		System.out.println(getName() + "׼��������ҵ�߻�����!");
		onLine1();
	}
	public void offLine() {
		System.out.println(getName() + "�°��°�!");
	}
}
