package homeWork;

import java.util.Date;

public class UserOperate {
	public static  UserInter login(String username,String password) {
		UserData userData = new UserData();
		System.out.println("0");
		for (int i = 0; i < userData.list.size();i++) {
			System.out.println("1");
			Object object = userData.list.get(i);
			if (object instanceof Person) {
				Person person = (Person) object;
				System.out.println("2");
				if (username.equals(person.getUsername())&&password.equals(person.getPssword())){
					System.out.println("登录成功!!!");
					Date date = new Date();
					System.out.println("当前时间:"+date);
					for (int j = 0; j < userData.list.size(); j++) {
						System.out.println(userData.list.get(j));
					}

					switch (i) {
					case 0:
					case 4:
						Worker worker = new Worker();
						//					worker.setName(userData.Userdata[i][0]);
						return worker;
					case 1:
						Doctor doctor = new Doctor();
						//					doctor.setName(userData.Userdata[i][0]);
						return doctor;
					case 2:
						Cooker cooker = new Cooker();
						//					cooker.setName(userData.Userdata[i][0]);
						return cooker;
					case 3:
						Boss boss = new Boss();
						//					boss.setName(userData.Userdata[i][0]);
						return boss;
					}
				}
			}System.out.println("输入错误!!!自行核对!!!");
			//		return null;
		}
		return null;
	}


	public static void register(Person person) {
		UserData userData = new UserData();
		userData.list.add(person);
		System.out.println("注册成功");
		for (int j = 0; j < userData.list.size(); j++) {
			System.out.println(userData.list.get(j));
		}

	}
}
