
public class Main {
	public static void main(String[] args) {
		// ����Ǵ�������Ĺ���
		// ʲô�Ƕ���
//		Car car = new Car();
		// �����ǽ�car�ĵ�ַ������car2
//		Car car2 = new Car();
		// Car����
		// car���Ƕ���
		// �Ǹ���Car����ഴ�������Ķ���
//		car.showInfo();
//		System.out.println(car == car2);
		
		Father father = new Father();
		Mother mother = new Mother();
		Child child = new Child();
		father.name = "��Ǯ�����";                              
		father.money = 20000;
		father.age = 30;
		mother.name = "��Ǯ������";
		mother.repast = "������";
		mother.age = 28;
		child.name = "��Ǯ����";
		child.school = "��󱱻�";
		child.age = 18;
		child.object = "����֣��";
		
		father.showInfo();
		mother.showInfo();
		child.showInfo();
	}
	
}
