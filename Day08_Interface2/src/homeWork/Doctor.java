package homeWork;

public class Doctor extends Person implements UserInter {
	public void onLine1() {
		System.out.println(getName() + "��������ʱ����ͷ��!");
	}
	public void onLine() {
		System.out.println(getName() + "��ʼ������!");
		onLine1();
	}
	public void offLine() {
		System.out.println(getName() + "������̫��,������!");
	}

}
