package com.wsh.must;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

public class HandSpeedGame {

    public static final String[] BYTES = {
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",//26//24-49
            "1","2","3","4","5","6","7","8","9","0",
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
            "~","!","@","#","$","%","^","&","*","(",")","_","+","{","}","[","]","<",">","?","/","|",",","."//24//0-23
    };

    public static void main(String[] args) {
//        System.out.println(BYTES.length);
//        for (int i = 0; i < 26; i++) {
//
//            int random = (int) (Math.random()*37);
//            System.out.println(BYTES[random]);
//        }

//        easy(10);
    }

    public static void Game(String username) throws IOException, DocumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到手速游戏测试平台:");
        System.out.println("请选择游戏难度:");
        System.out.println("Ⅰ.简单(10个字符)\nⅡ.一般(20个字符)\nⅢ.困难(30个字符)");
        int number = 0;
        switch (scanner.nextInt()){
            case 1:
                scanner.nextLine();
                number = 10;
                break;
            case 2:
                scanner.nextLine();
                number = 20;
                break;
            case 3:
                scanner.nextLine();
                number = 30;
                break;
        }
        easy(number,username);
    }
    public static void easy(int number,String username) throws IOException, DocumentException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 3; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("游戏"+i+"秒后开始");
        }
        System.out.println("游戏开始!");
        long time1 = new Date().getTime();
        String [] gameList = new String[number];
        String list = "";
        for (int i = 0; i < gameList.length; i++) {
            int random = 0;
            if (number == 10){
                random = (int) (Math.random()*36);
            }
            if (number == 20){
                random = (int)(Math.random()*62);
            }
            if (number == 30){
                random = (int)(Math.random()*86);
            }
            gameList[i] = BYTES[random];
            list = list + gameList[i];
        }
        System.out.println(list);
        String input = scanner.nextLine();
        if (input.equals(list)){
            long time2 = new Date().getTime();
            long time = time2 - time1;
            System.out.println("恭喜你!成绩为:" + time + "毫秒");
            output(time,username);
        }else {
            System.out.println("游戏失败!");
        }
    }

    public static void output(long time,String username) throws IOException, DocumentException {
        URL url = new URL("http://192.168.20.221:8080/day16/insert?username="+username+"&score="+time);
        url.openConnection();
        System.out.println("成绩已提交成功!");
        getFirst();
    }

    public static void getFirst() throws IOException, DocumentException {

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new URL("http://192.168.20.221:8080/day16/first"));
        Element rootElement = document.getRootElement();
        String nickname = rootElement.element("nickname").getText();
        String score = rootElement.element("score").getText();
        System.out.println("目前第一名为:"+nickname+",分数为:"+score);
    }
}
