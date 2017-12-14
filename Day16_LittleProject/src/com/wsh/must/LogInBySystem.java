package com.wsh.must;

import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class LogInBySystem {
    public static void logIn() throws DocumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号:");
        String userName = scanner.nextLine();
        UserData userData = LogInBySource.logIn(userName);
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
                                GetWeather.getWeather();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                GetPhoneBelong.getPhone();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            break;
                        case 4:
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





}
