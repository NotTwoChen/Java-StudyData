package inter;

import com.lanou3g.study.Doctor;

public class Main {
	public static void main(String[] args) {
		/*
		 * interface:�ӿ�
		 * class:��
		 * 
		 * ����������java����һ�������
		 * ����һ�ֲ��еĹ�ϵ
		 * 
		 * java�нӿ�,��ʾһ���淶���߹���
		 * �����಻��ֱ�Ӵ�������,���ǿ���ʹ��
		 * �����������
		 * 		����ղŽ���person����һ��������
		 * 			person p;����һ������
		 * 
		 * �ӿ�Ҳ�����Ƶ�,Ҳ����ֱ�Ӵ�������
		 * ���ǿ���ʹ�ýӿڵ�����
		 * 
		 */
		
		// ��������������wd
		// ���������������
		// ���һ������û������
		// ��ô������������
//		WatchDog wd = new WatchDog();
		
		Company facebook = new Company();
		// �����Work��Ҫ����ȥһ��ʲô��?
		facebook.setWork(new WatchDog());
		
		facebook.setWork(new Doctor());
		
		facebook.startWork();
		facebook.endWork();
	}
}