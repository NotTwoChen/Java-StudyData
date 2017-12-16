package com.wsh.user;

import com.wsh.exception.UserDataException;
import com.wsh.util.Console;
import org.dom4j.DocumentException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) { System.out.println("Ⅰ.注册\nⅡ.登录");
            switch (scanner.nextInt()) {
                case 1: scanner.nextLine();
                    try { Console.signIn();
                    } catch (IOException e) { e.printStackTrace();
                    } catch (DocumentException e) { e.printStackTrace();
                    } catch (UserDataException e) { System.out.println(e.getMessage()); }
                    break;
                case 2: scanner.nextLine();
                    try { Console.logIn();
                    } catch (IOException e) { e.printStackTrace();
                    } catch (DocumentException e) { e.printStackTrace();
                    } catch (UserDataException e) { System.out.println(e.getMessage()); }
                    break;
                default: System.out.println("选择操作错误!");
                    break; } } }
}
