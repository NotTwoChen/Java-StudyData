package com.wsh.contact;

import com.wsh.constant.Constant;
import com.wsh.must.Visit;
import com.wsh.must.HandSpeedGame;
import com.wsh.user.UserData;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Console {
    static SAXReader saxReader = new SAXReader();
    static File file = new File(Constant.USERDATA_PATH);
    public static void signIn() throws DocumentException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号:");
        String newUserName = scanner.nextLine();
        if (isPhone(newUserName)||isEmail(newUserName)){
            if (signIn(newUserName)) {
                System.out.println("请输入密码:");
                String newPassWord = scanner.nextLine();
                if (isPassword(newPassWord)) {
                    System.out.println("请输入用户昵称:");
                    String newName = scanner.nextLine();
                    if (isName(newName)) {
                        Source.signIn(newUserName, newPassWord, newName);
                        System.out.println("用户注册成功!");
                    } else { System.out.println("昵称输入错误!");
                    }
                } else { System.out.println("密码输入错误!");
                }
            }else{ System.out.println("账号已存在!");
            }
        }else { System.out.println("账号输入错误!");
        }
    }
    public static void logIn() throws DocumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号:");
        String userName = scanner.nextLine();
        UserData userData = Source.logIn(userName);
        if (userData != null){
            System.out.println("请输入密码:");
            String passWord = scanner.nextLine();
            if (passWord.equals(userData.getPassWord())){
                System.out.println("用户"+userData.getName()+"登录成功!");
                while(true) {
                    System.out.println("请选择需要操作的功能:");
                    System.out.println("Ⅰ.查询天气\nⅡ.查询手机号归属地\nⅢ.手速游戏\nⅣ.查询手速游戏全国排行榜");
                    switch (scanner.nextInt()) {
                        case 1:
                            try {
                                Visit.getWeather();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                Visit.getPhone();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            try {
                                HandSpeedGame.Game(userData.getName());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 4:
                            try {
                                Visit.getTop();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            System.out.println("选择操作错误!");
                            break;
                    }
                }
            } else{
                System.out.println("密码不正确!");
            }
        }else{
            System.out.println("账号不存在!");
        }
    }
    public static boolean isName(String name){
        return Pattern.matches(Constant.REGEX_NAME,name);
    }
    public static boolean isPhone(String userName){
        return Pattern.matches(Constant.REGEX_PHONE, userName);
    }
    public static boolean isEmail(String userName){
        return Pattern.matches(Constant.REGEX_EMAIL,userName);
    }
    public static boolean isPassword(String passWord){
        return Pattern.matches(Constant.REGEX_PASSWORD,passWord);
    }
    public static boolean signIn( String userName ) throws DocumentException {
        Document read = saxReader.read(file);
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            String text = element.element("userName").getText();
            if (text.equals(userName)){
                System.out.println("账号已存在!");
                return false;
            }
        }return true;
    }
}
