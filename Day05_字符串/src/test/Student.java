package test;
public class Student {
	// ��װ
	private String name = "ֵ";
	
	// ��¶��һ�������ķ���ȥ����/���
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	public void smile () {
		System.out.println("���������ӡ01");
	}
	
	private void cry() {
		System.out.println("���������ӡ02");
	}
	protected void angry() {
		System.out.println("���������ӡ03");
	}
	
	String sad() {
		return "���������ӡ04";
	}

}
