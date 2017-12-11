package com.lanou3g.RLFunction;

import com.lanou3g.RLFunction.Exception.UserDataException;
import com.lanou3g.RLFunction.method.UserOperate;
import com.lanou3g.RLFunction.userInter.UserInter;
import com.lanou3g.RLFunction.userdata.Person;
import com.lanou3g.RLFunction.userdata.UserData;
import com.lanou3g.RLFunction.works.Boss;
import com.lanou3g.RLFunction.works.Cooker;
import com.lanou3g.RLFunction.works.Doctor;
import com.lanou3g.RLFunction.works.Worker;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    private static final int REGISTER_CODE= 1,LOGIN_CODE = 2,FORGETTHEPASSWORD_CODE = 3,WORKER = 1,DOCTOR = 2,
            COOKER = 3,BOOS = 4,START= 1,STOP = 2,REMOVE = 3,CHANGE = 4,LOGOFF = 5;
    static String username = null,password = null;
    static boolean WORK = true;
    public static void main(String[] args) throws IOException, DocumentException {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("------1.注册------\n------2.登录------\n------3.忘记密码--");
            int choice = scanner.nextInt();
            switch (choice) {
                case REGISTER_CODE:
                    scanner.nextLine();
                    System.out.println("~请输入用户昵称:");
                    String name = scanner.nextLine();
                    receive(scanner);
                    System.out.println("~请选择用户职业:");
                    System.out.println("1.Worker/2.Doctor/3.Cooker/4.Boss");
                    int input = scanner.nextInt();
                    Person person = null;
                    switch (input) {
                        case WORKER:
                            person = new Worker(name, username, password, "Worker");
                            break;
                        case DOCTOR:
                            person = new Doctor(name, username, password, "Doctor");
                            break;
                        case COOKER:
                            person = new Cooker(name, username, password, "Cooker");
                            break;
                        case BOOS:
                            person = new Boss(name, username, password, "Boss");
                            break;
                    }
                    try {
                        UserOperate.register(person);
                    } catch (UserDataException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                case LOGIN_CODE:
                    scanner.nextLine();
                    receive(scanner);
                    UserInter ui;
                    try {
                        ui = UserOperate.login(username, password);
                    } catch (UserDataException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    do{ System.out.println("~1.开始工作\n~2.结束工作\n~3.注销账户\n~4.修改信息\n~5.退出登录");
                        int choices = scanner.nextInt();
                        switch (choices) {
                            case START:
                                ui.onLine();
                                break;
                            case STOP:
                                ui.offLine();
                                break;
                            case REMOVE:
                                authentication(scanner);
                                try {
                                    boolean logout = UserOperate.logout(username, password);
                                    if (logout) {
                                        WORK = false;
                                    }
                                } catch (UserDataException e) {
                                    System.out.println(e.getMessage());
                                    continue;
                                }
                                break;
                            case CHANGE:
                                authentication(scanner);
                                try {
                                    boolean change = UserOperate.change(username, password);
                                    if (change){
                                        System.out.println("---请重新登录!!!---");
                                        WORK = false;
                                    }
                                } catch (UserDataException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case LOGOFF:
                                WORK = false;
                                System.out.println("---退出登录成功!!!---");
                                break;
                            default:
                                System.out.println("输入错误!!!");
                                break;
                        }
                    }while(WORK);
                    break;
                case FORGETTHEPASSWORD_CODE:
                    System.out.println("~请输入需要找回密码的账号:");
                    scanner.nextLine();
                    username = scanner.nextLine();
                    System.out.println("~请填写核对信息完成账户校准:");
                    System.out.println("请确认用户姓名:");
                    String entryName = scanner.nextLine();
                    System.out.println("~请确认用户职业:");
                    System.out.println("1.Worker/2.Doctor/3.Cooker/4.Boss");
                    int entryWork = scanner.nextInt();
                    boolean result = UserOperate.forgetThePassword(username, entryName, entryWork);
                    if (result){
                        System.out.println("~请输入新的用户密码:");
                        scanner.nextLine();
                        String newPassword = scanner.nextLine();
                        UserData.changePerson(username,newPassword,1);
                    }
                    break;
                default:
                    System.out.println("输入错误,请重新选择!!!");
                    break;
            }
        }
    }
    private static void authentication(Scanner scanner) {
        System.out.println("~请输入用户密码验证身份:");
        scanner.nextLine();
        password = scanner.nextLine();
    }

    private static void receive(Scanner scanner) {
        System.out.println("~请输入用户名:");
        username = scanner.nextLine();
        System.out.println("~请输入用户密码:");
        password = scanner.nextLine();
    }
}
