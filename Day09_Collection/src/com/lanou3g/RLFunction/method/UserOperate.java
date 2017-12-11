package com.lanou3g.RLFunction.method;

import com.lanou3g.RLFunction.Exception.LoginErrorFromUsernameIsNullErrorException;
import com.lanou3g.RLFunction.Exception.LoginErrorFromUsernameOrPasswordIsWrongErrorException;
import com.lanou3g.RLFunction.Exception.RegisterErrorFromUsernameHaveBeenUsedErrorException;
import com.lanou3g.RLFunction.Exception.UserDataException;
import com.lanou3g.RLFunction.userInter.UserInter;
import com.lanou3g.RLFunction.userdata.Person;
import com.lanou3g.RLFunction.userdata.UserData;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.io.IOException;
import java.text.*;
import java.util.List;
import java.util.Scanner;

/**
 *  用户操作系统所需要的工具类
 */
public class UserOperate {
    // 登录方法
    public static UserInter login(String username, String password) throws UserDataException, DocumentException {
        Person person = UserData.getPerson(username);
        if (person != null) {
            if (person.getPassword().equals(password)) {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(".");
                }
                System.out.println();
                System.out.println("-----登录成功!!!-----");
                System.out.println(person.toString());
                long l = System.currentTimeMillis();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                System.out.println("③当前时间:" + dateFormat.format(l));
                return person;
            } else {
                throw new LoginErrorFromUsernameOrPasswordIsWrongErrorException();
            }
        }
        throw new LoginErrorFromUsernameIsNullErrorException();

    }
    // 注册方法
    public static void register(Person person) throws UserDataException, IOException, DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src/com/lanou3g/RLFunction/userdata/UserData.xml"));
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements("person");
        for (Element element : elements) {
            Element username = element.element("username");
            if (username.getText().equals(person.getUsername())){
                throw new RegisterErrorFromUsernameHaveBeenUsedErrorException();
            }
        }
        System.out.println("------注册成功!!!-----");
        UserData.setPerson(person);
    }
    // 注销方法
    public static boolean logout(String name,String password) throws IOException, DocumentException, LoginErrorFromUsernameIsNullErrorException, LoginErrorFromUsernameOrPasswordIsWrongErrorException {

        Person person = UserData.getPerson(name);
        if (person != null){
            if (person.getPassword().equals(password)){
                System.out.println("---验证密码成功!!!---");
                System.out.println("~是否确认注销账户?");
                System.out.println("------1.是------\n------2.否------");
                int YesOrNo = new Scanner(System.in).nextInt();
                switch (YesOrNo){
                    case 1:
                        UserData.removePerson(name);
                        System.out.println("------注销成功!!!------");
                        return true;
                    case 2:
                        return false;
                }
            }
            throw new LoginErrorFromUsernameOrPasswordIsWrongErrorException();
        }
        throw new LoginErrorFromUsernameIsNullErrorException();
    }
    // 修改方法
    public static boolean change(String name,String password) throws DocumentException, LoginErrorFromUsernameOrPasswordIsWrongErrorException, LoginErrorFromUsernameIsNullErrorException, IOException {
        Scanner scanner = new Scanner(System.in);
        Person person = UserData.getPerson(name);
        if (person != null) {
            if (person.getPassword().equals(password)) {
                System.out.println("---验证密码成功!!!---");
                System.out.println("~请选择需要修改的信息:");
                System.out.println("---1.修改用户密码---\n---2.修改用户姓名---\n---3.修改用户职业---");
                int changeInt = scanner.nextInt();
                String change = null;
                if (changeInt == 3){
                    System.out.println("请重新选择用户职业:");
                    System.out.println("1.Worker/2.Doctor/3.Cooker/4.Boss");
                    int changeInt2 = scanner.nextInt();
                    switch (changeInt2){
                        case 1:
                            change = "Worker";
                            break;
                        case 2:
                            change = "Doctor";
                            break;
                        case 3:
                            change = "Cooker";
                            break;
                        case 4:
                            change = "Boss";
                            break;
                    }
                }else {
                    System.out.println("~请输入修改后的数据:");
                    scanner.nextLine();
                    change = scanner.nextLine();
                }
                boolean changePerson = UserData.changePerson(name, change, changeInt);
                if (changePerson){
                    return true;
                }
                return false;
            }
            throw new LoginErrorFromUsernameOrPasswordIsWrongErrorException();
        }
        throw new LoginErrorFromUsernameIsNullErrorException();
    }
    // 核对方法
    public static boolean forgetThePassword(String username,String name,int workChoice) throws DocumentException, IOException {
        Person person = UserData.getPerson(username);
        if (person == null){
            return false;
        }
        String work = null;
        switch (workChoice){
            case 1:
                work = "Worker";
                break;
            case 2:
                work = "Doctor";
                break;
            case 3:
                work = "Cooker";
                break;
            case 4:
                work = "Boss";
                break;
            default:
                System.out.println("---选择错误!!!---");
                return false;
        }
        if (person.getName().equals(name)&&person.getWork().equals(work)){
            return true;
        }else{
            System.out.println("用户姓名或者用户职业核对错误,请确认后再进行操作");
            return false;
        }
    }

}

