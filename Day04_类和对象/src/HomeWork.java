
public class HomeWork {
	public static void main(String[] args) {
		Courier courier = new Courier();
		courier.name = "��һ";
		courier.work = "���Ա";
		courier.sex = "��";
		courier.age = 35;
		courier.Delivery();
		courier.WorkTime(11);
		System.out.println(courier.Salary());
		System.out.println(courier.DeliveryGoods(20));
		SalesPerson salesPerson = new SalesPerson();
		salesPerson.name = "Ǯ��";
		salesPerson.work = "�ۻ�Ա";
		salesPerson.sex = "Ů";
		salesPerson.age = 25;
		salesPerson.Salesclerk();
		salesPerson.WorkTime(12);
		System.out.println(salesPerson.Shop());
		System.out.println(salesPerson.Assistant(100));
	}
}
class people{
	
	/*
	 * �ĸ����ĸ�����
	 * ����/����/�Ա�/����
	 */
	String name;
	String work;
	String sex;
	int age;
	/**
	 * 	����������������ֵ:  (null) void
		��������������ֵ:(null) ����
		��������������ֵ:(����)void
		������������ֵ:(����)����
	 */
	
}
// ���Ա
class Courier extends people{
	public void Delivery(){
		System.out.println(name+"��һ��"+age+"���"+sex+"��,ְҵ��"+work);
	}
	public String Salary() {
		return name + "��ϲ�����ڵ����";
	}
	public void WorkTime(int time) {
		System.out.println(name+"�Ѿ�������"+time+"����");
	}
	public String DeliveryGoods(int goods) {
		return name + "�����Ѿ�����" + goods + "������";
	}
}
// �ۻ�Ա
class SalesPerson extends people{
	public void Salesclerk() {
		System.out.println(name+"��һ��"+age+"���"+sex+"��,ְҵ��"+work);
	}
	public String Shop() {
		return name + "���������ڵĹ���";
	}
	public void WorkTime(int time) {
		System.out.println(name+"ÿ�춼Ҫ��"+time+"��Сʱ�Ĺ���");
	}
	public String Assistant(int guest) {
		return name + "�������ٽӴ��˽�" + guest + "������";
	}
}
// ѧ��
class BigStudent extends people{
	 
}
// ��ʦ
class teacher extends people{
	
}
