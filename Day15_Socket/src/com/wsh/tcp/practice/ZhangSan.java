package com.wsh.tcp.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ZhangSan {

    public static void main(String[] args) throws IOException {
        // 把张三写成发送方

        Socket socket = new Socket("192.168.20.210",4567);

        Scanner scanner = new Scanner(System.in);

        OutputStream outputStream = socket.getOutputStream();

        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];


        String send = "";
        while (!(send = scanner.nextLine()).equals("quit")) {
            // 如果输入的内容不是quit,那么程序继续
            outputStream.write(send.getBytes());

            int read = inputStream.read(bytes);

            System.out.println(new String(bytes,0,read));
        }
            socket.close();

        // 如果输入了quit,则循环终止
        // 那么关闭这个socket


    }
}
