package com.wsh.main;

import com.wsh.contact.Console;
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
                        Console.signIn();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    try {
                        Console.logIn();
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
