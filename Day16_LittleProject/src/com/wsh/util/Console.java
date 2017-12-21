package com.wsh.util;

import com.wsh.exception.*;
import com.wsh.user.UserData;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Console {
    static SAXReader saxReader = new SAXReader();
    static File file = new File(Constant.USERDATA_PATH);

    public static void signIn() throws DocumentException, IOException, UserDataException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号:");
        String newUserName = scanner.nextLine();
        if (isPhone(newUserName)||isEmail(newUserName)){
            if (inspect(newUserName)) { System.out.println("请输入密码:");
                String newPassWord = scanner.nextLine();
                if (isPassword(newPassWord)) { System.out.println("请输入用户昵称:");
                    String newName = scanner.nextLine();
                    if (isName(newName)) { System.out.println("用户注册成功!");
                        Mysql.signIn(newName, newUserName, newPassWord);
                    } else { throw new NameInputErrorException(); }
                } else { throw new PasswordInputErrorException(); }
            }else{ throw new UserNameExistException(); }
        }else { throw new UsernameInputErrorException(); }
    }

    public static void logIn() throws DocumentException, UserDataException, IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号:");
        UserData userData = Mysql.logIn(scanner.nextLine());
        if (userData != null){ System.out.println("请输入密码:");
            String passWord = scanner.nextLine();
            if (passWord.equals(userData.getPassWord())){ System.out.println("用户"+userData.getName()+"登录成功!");
            boolean b = true;
                while(b) { System.out.println("请选择需要操作的功能:\nⅠ.查询天气\nⅡ.查询手机号归属地\nⅢ.手速游戏\nⅣ.查询手速游戏全国排行榜\nⅤ.修改用户信息\nⅥ.注销账户");
                    switch (scanner.nextInt()) {
                        case 1: Visit.weatherFuture();
                            break;
                        case 2: Visit.phoneGet();
                            break;
                        case 3: Visit.startGame(userData.getName());
                            break;
                        case 4: Visit.getTop();
                            break;
                        case 5: b = Visit.alterUserdata(userData);
                            break;
                        case 6: b = !Visit.updateUserdata(userData);
                            break;
                        default: throw new SelectErrorException(); } }
            } else{ throw new UserNameMismatchingPassWordException(); }
        }else{ throw new UsernameInExistenceException(); }
    }

    public static boolean inspect(String userName ) throws DocumentException, SQLException {
        List<UserData> userData = Mysql.getUserData();
        for (UserData userDatum : userData) {
            if (userDatum.getUserName().equals(userName)){
                return false; } }return true;
    }

    public static boolean isName(String name){ return Pattern.matches(Constant.REGEX_NAME,name); }

    public static boolean isPhone(String userName){ return Pattern.matches(Constant.REGEX_PHONE, userName); }

    public static boolean isEmail(String userName){ return Pattern.matches(Constant.REGEX_EMAIL,userName); }

    public static boolean isPassword(String passWord){ return Pattern.matches(Constant.REGEX_PASSWORD,passWord); }
}
