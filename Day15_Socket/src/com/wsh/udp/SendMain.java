package com.wsh.udp;

import com.wsh.util.Constants;

import java.io.IOException;
import java.net.*;

public class SendMain {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(4564);

        // 创建一个地址对象,将ip地址传到构造方法中
        InetAddress address = InetAddress.getByName("192.168.20.221");

        byte[] bytes = new byte[1024];

        bytes = "我是谁?".getBytes();
        // 创建用来存储数据的数据包
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,address,8080);

        datagramSocket.send(datagramPacket);


    }
}
