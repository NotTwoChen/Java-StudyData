package homeWork;
import java.util.Date;
public class Login implements UserInter{
	public void onLine() {
	}
	public void offLine() {
	}
	public static  UserInter login(String username,String password) {
		UserData userData = new UserData();
		for (int i = 0; i < userData.Userdata.length;i++) {
			if (username.equals(userData.Userdata[i][1])&&password.equals(userData.Userdata[i][2])) {
				System.out.println("��¼�ɹ�!!!");
				Person person = new Person();
				Date date = new Date();
				person.setName(userData.Userdata[i][0]);
				person.setWork(userData.Userdata[i][3]);
				System.out.println("�û�����:"+person.getName());
				System.out.println("�û�ְҵ:"+person.getWork());
				System.out.println("��ǰʱ��:"+date);
				
				switch (i) {
				case 0:
				case 4:
					Worker worker = new Worker();
					worker.setName(userData.Userdata[i][0]);
					return worker;
				case 1:
					Doctor doctor = new Doctor();
					doctor.setName(userData.Userdata[i][0]);
					return doctor;
				case 2:
					Cooker cooker = new Cooker();
					cooker.setName(userData.Userdata[i][0]);
					return cooker;
				case 3:
					Boss boss = new Boss();
					boss.setName(userData.Userdata[i][0]);
					return boss;
				}
			}
		}System.out.println("�������!!!���к˶�!!!");
		return null;
	}
}