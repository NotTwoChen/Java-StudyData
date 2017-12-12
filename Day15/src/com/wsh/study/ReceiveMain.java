package com.wsh.study;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveMain {

    public static void main(String[] args) throws IOException {

        // 创建一个接收方ServerSocket对象
        // 构造方法中传入的参数为9909
        ServerSocket serverSocket = new ServerSocket(9909);

        // 从接收方,得到是谁发过来的
        // 因为接收方和发送方会建立连接
        // 这里就是通过接收方,获得发送方
        // accept方法是一个阻塞式方法
        // 如果获得不到发送方的socket,那么就会将程序阻塞在这里,不再向下执行
        Socket accept = serverSocket.accept();

        // 获得发送方的读取对象
        InputStream inputStream = accept.getInputStream();

        byte[] bytes = new byte[1024];

        // 调用inputStream的读取方法
        // 将accept中的内容
        // 读取到bytes这个字节数组中
        inputStream.read(bytes);

        String content = new String(bytes);

        System.out.println(content);

        accept.close();


    }
}
