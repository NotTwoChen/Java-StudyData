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

        StringBuffer sb = new StringBuffer();
        int len = 0;
        while((len= inputStream.read(bytes)) != -1){
            String a = new String(bytes,0,len);
            sb.append(a);
            System.out.println(sb);
            sb.setLength(0);

            String result = scanner.nextLine();
            outputStream.write(result.getBytes());
        }
        serverSocket.close();
    }
}
