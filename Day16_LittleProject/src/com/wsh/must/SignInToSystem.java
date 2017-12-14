package com.wsh.must;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SignInToSystem {

    public static SAXReader saxReader = new SAXReader();
    public static File file = new File("src\\com\\wsh\\must\\UserData.xml");
    public static boolean isName(String name){
        return Pattern.matches(Verification.REGEX_NAME,name);
    }
    public static boolean isPhone(String userName){
        return Pattern.matches(Verification.REGEX_PHONE, userName);
    }
    public static boolean isEmail(String userName){
        return Pattern.matches(Verification.REGEX_EMAIL,userName);
    }
    public static boolean isPassword(String passWord){
        return Pattern.matches(Verification.REGEX_PASSWORD,passWord);
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
                        SignInToSource.signIn(newUserName, newPassWord, newName);
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

}
