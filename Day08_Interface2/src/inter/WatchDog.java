package inter;

/**
 * WatchDog��,ͨ��implements�ؼ���
 * ��Work�ӿڲ����˹���,����WathcDog��������Work����ӿڵĹ淶
 * 
 * Implements�ؼ���:ʵ��
 * ͨ��implements�ؼ���,������һ����
 * ʵ�ֶ���ӿ�,����ӿ�֮��ͨ�����ŷָ�
 * �������������,�����˽ӿڵĹ淶
 * Ҳ����ʵ���˽ӿ�
 * 
 * A�̳���B,��ôA��������,B��������
 * Aʵ����C,��ôA����ʵ����,C�����ӿ�
 * @author lanou3g
 *
 */
public class WatchDog implements Work{

	@Override
	public void work() {
		System.out.println("����һֱ���Ź�,��Ҫ����");
	}

	@Override
	public void goHome() {
		System.out.println("���Ѿ���������,�ؼ�˯���Թ�ͷ");
	}
	
}
