package test;

public class Main {
	public static void main(String[] args) {
		Student student = new Student();
		Student student2 = new Student();
//		student.name = "����";
		// ͨ��getName����
		// �õ�student�����name����
		String name = student.getName();
		// ��ִ��setName����ʱ,�ͽ����ֵ�����˲����б��еĲ���n
		name = student2.getName();
		System.out.println("��֮ǰ"+name);
		student2.setName("����ֵ");
		name = student2.getName();
		System.out.println("��֮��"+name);
		
		// �õ�sad����ִ�еĽ��
		// ����������ֵ����result�������
//		String result = student.sad();
		// ���
//		System.out.println(result);
	}
}
