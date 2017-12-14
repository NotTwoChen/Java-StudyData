package com.wsh.must;

import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Ⅰ.注册\nⅡ.登录");
            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    try {
                        SignInToSystem.signIn();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    try {
                        LogInBySystem.logIn();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("选择操作错误!");
                    break;
            }
        }
    }
}
