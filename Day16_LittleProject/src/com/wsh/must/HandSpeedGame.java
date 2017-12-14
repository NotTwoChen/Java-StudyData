package com.wsh.must;

import java.io.IOException;
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

        easy(10);
    }

    public static void Game(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到手速游戏测试平台:");
        System.out.println("请选择游戏难度:");
        System.out.println("Ⅰ.简单(10个字符)\nⅡ.一般(20个字符)\nⅢ.困难(30个字符)");
        switch (scanner.nextInt()){
            case 1:
                scanner.nextLine();
                break;
            case 2:
                break;
            case 3:
                break;
        }


    }
    public static void easy(int number){
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
        String [] gameList = new String[10];
        String list = "";
        for (int i = 0; i < gameList.length; i++) {
            int random = (int) (Math.random()*36);
            gameList[i] = BYTES[random];
            list = list + gameList[i];
        }
        System.out.println(list);
        String input = scanner.nextLine();
        if (input.equals(list)){
            long time2 = new Date().getTime();
            long time = time2 - time1;
            System.out.println("恭喜你!成绩为:" + time + "毫秒");
        }



    }

    public static void output(long time,String username) throws IOException {

        URL url = new URL("http://192.168.20.221:8080/day16/insert?username="+username+"&score="+time);

        URLConnection urlConnection = url.openConnection();

        OutputStream outputStream = urlConnection.getOutputStream();

        outputStream.write();
    }
}
