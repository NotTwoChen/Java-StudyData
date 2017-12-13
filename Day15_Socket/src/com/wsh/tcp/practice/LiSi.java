package com.wsh.tcp.practice;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class LiSi {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(6666);
        Scanner scanner = new Scanner(System.in);
        Socket accept = serverSocket.accept();
        byte[] bytes = new byte[1024];
        InputStream inputStream = accept.getInputStream();

        // 获得与这个ServerSocket连接的Socket的输出流
        OutputStream outputStream = accept.getOutputStream();

        new Thread(){
            @Override
            public void run() {
                super.run();
                StringBuffer sb = new StringBuffer();
                int len = 0;
                try {
                    while((len= inputStream.read(bytes)) != -1){
                        sb.append(new String(bytes,0,len));
                        System.out.println(sb);
                        sb.setLength(0);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        String send = "";
        while (!(send = scanner.nextLine()).equals("quit")) {
            // 如果输入的内容不是quit,那么程序继续

            outputStream.write(send.getBytes());
        }


        /*String result = scanner.nextLine();
        outputStream.write(result.getBytes());*/
        serverSocket.close();
    }
}
