
public class liStudent {
	String name;
	String school;
	int id;
	
	public void play() {
		System.out.println(name + "����Ϸȥ��");
		
	}
	
	public void goToStudy() {
		System.out.println(name + "ȥ��ѧ��,ѧУ��" + school);
		
	}
	
	/*
	 *  public	Ȩ�����η�
	 *  void	����ֵ����
	 *  show	������
	 *  (String str)	�����б�, �ǿ����ж��������
	 *  			String �ǲ���������
	 *  				���÷�����,��Ҫ����������͵�����
	 *  			str		�ǲ���������
	 *  				�������,����ôд����ôд
	 *  				����Ҫ����֪��
	 *  {}	������
	 *  		���������������ʱ,Ҫִ�еĴ���
	 */
	public void show (String str) {
		
	}
	
	public void buyOutFood(int money) {
		System.out.println("������ʦ��Ǯ"+ money+ "ȥ����Ϸ��");
	}
	
	// �����ѧ���߱�һ���ӷ����������
	
	public void addOperation(int a , int b) {
		System.out.println(name+"��"+a+"+"+b+"="+(a+b)+"�������");
	}
	
	// public ��������String
	// ��ʾ����ֵ��������String ,���ַ���
	public String hot (String food) {
		return "�����˵�"+ food;
	}
}
