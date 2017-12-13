package com.wsh.tcp.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ZhangSan {
    static String send = "";
    public static void main(String[] args) throws IOException {
        // 把张三写成发送方

        Socket socket = new Socket("192.168.20.195",6666);
        Scanner scanner = new Scanner(System.in);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];


        new Thread(){
            @Override
            public void run() {
                super.run();
                while (!(send = scanner.nextLine()).equals("quit")) {
                    // 如果输入的内容不是quit,那么程序继续
                    try {
                        outputStream.write(send.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        }.start();

        StringBuffer sb = new StringBuffer();
        int len = 0;
        while((len= inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len));
            System.out.println(sb);
            sb.setLength(0);
        }

        /*int read = inputStream.read(bytes);
        System.out.println(new String(bytes,0,read));*/

        socket.close();
        // 如果输入了quit,则循环终止
        // 那么关闭这个socket


    }
}
