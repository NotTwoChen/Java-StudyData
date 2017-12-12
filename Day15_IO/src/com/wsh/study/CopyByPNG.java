package com.wsh.study;

import java.io.*;

public class CopyByPNG {

    public static void main(String[] args) throws IOException {

//        FileReader fileReader = new FileReader("src\\我是一张图.png");

        FileOutputStream fileOutputStream = new FileOutputStream("src\\我是一张图2.jpg");
        FileInputStream fileInputStream = new FileInputStream("src\\我是一张图.png");

//        char[] chars = new char[1024*1024];

        byte[] bytes = new byte[1024*1024*10];

        fileInputStream.read(bytes);
        fileOutputStream.write(bytes);

        fileOutputStream.close();
        fileInputStream.close();




//        FileWriter fileWriter = new FileWriter("src\\我是一张图2.png");

//        fileWriter.close();
//        fileReader.close();

    }
}
