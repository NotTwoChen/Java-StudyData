package homeWork;

public class Cooker extends Person implements UserInter {
	public void onLine1() {
		System.out.println(getName() + "���˵�ʱ��ϲ������!");
	}
	public void onLine() {
		System.out.println(getName() + "׼��ʳ��������!");
		onLine1();
	}
	public void offLine() {
		System.out.println(getName() + "�Ա�����������!");
	}
}
