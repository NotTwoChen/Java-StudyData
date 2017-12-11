import java.util.Arrays;
import java.util.Scanner;

public class RegisterAndLogin{
	@SuppressWarnings("resource")
	public static void main(String[] args){
		int id [] = new int[1];
		int password [] = new int [1];
		String name [] = new String[1];
		Scanner entry = new Scanner(System.in);
		int i1 = 0;
		while(true) {
			System.out.println(Arrays.toString(id));
			System.out.println(Arrays.toString(password));
			System.out.println(Arrays.toString(name));
			System.out.println("----------1.×¢²á----------");
			System.out.println("----------2.µÇÂ¼----------");
			int option = entry.nextInt();
			switch (option) {
			case 1:
				System.out.println("¢Å×¢²áÕËºÅ:");
				int idEnroll = entry.nextInt();
				if (id[id.length-1] != 0 || password[password.length-1] != 0 || name[name.length-1] != null) {
					id = Arrays.copyOf(id, id.length+1);
					password = Arrays.copyOf(password,password.length+1);
					name = Arrays.copyOf(name, name.length+1);
				}
				if (id[i1] != 0) {
					i1++;
				}
				int b = 0 ;
				for (int j = 0; j < id.length; j++) {
					for (int j2 = 0; j2 < id.length; j2++) 
						if (id[j2] == idEnroll) {
							System.out.println("¸ÃÕËºÅÒÑ´æÔÚ");
							j = id.length;
							b = 1;
							break;
						}
						if (b == 1) {
							continue;
						}
						if (id[j] != idEnroll) {
							System.out.println("¢Æ×¢²áÃÜÂë:");
							int passwordEnroll = entry.nextInt();
							System.out.println("¢ÇÈ·ÈÏÃÜÂë:");
							int passwordVerify = entry.nextInt();
							entry.nextLine();
							System.out.println("¢È×¢²áêÇ³Æ");
							String nameEnroll = entry.nextLine();
							if (passwordVerify == passwordEnroll) {
								id[i1] = idEnroll;
								password[i1] = passwordEnroll;
								name[i1] = nameEnroll;
								System.out.println("!!!×¢²á³É¹¦!!!");
								break;
							}else {
								System.out.println("!!!ÃÜÂë²»Ò»ÖÂ,×¢²áÊ§°Ü!!!");
							}
							j = id.length;}}
				break;
			case 2:
				System.out.println("¢ÅµÇÂ¼ÕËºÅ:");
				int idEnter = entry.nextInt();
				for (int i2 = 0; i2 < id.length; i2++) {
					if (id[i2] != idEnter && i2 == id.length-1) {
						System.out.println("¸ÃÕËºÅ²»´æÔÚ");
					}if(id[i2] == idEnter) {
						System.out.println("¢ÆµÇÂ¼ÃÜÂë:");
						int passwordEnter =entry.nextInt();
						if (passwordEnter != password[i2]) {
							System.out.println("!!!ÃÜÂëÊäÈë´íÎó!!!");
						}else {
							System.out.println("!!!µÇÂ¼³É¹¦!!!");
							System.out.println("!!!»¶Ó­"+name[i2]+"µÇÂ¼ÏµÍ³!!!");
							break;
							}
						}
					}
				break;
			default:
				System.out.println("!!!ÊäÈë´íÎó,ÇëÖØÐÂÊäÈë!!!");
				break;
			}
		}
	}
}

