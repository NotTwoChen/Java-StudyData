package homeWork;
public class Worker extends Person implements UserInter {
	public void onLine1() {
		System.out.println(getName() + "��������̫�;����չ�!");
	}
	public void onLine() {
		System.out.println(getName() + "��ʼ�ɻ���!");
		onLine1();
	}
	public void offLine() {
		System.out.println(getName() + "����ؼ���!");
	}
}