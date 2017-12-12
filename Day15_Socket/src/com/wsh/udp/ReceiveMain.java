package com.wsh.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveMain {

    public static void main(String[] args) throws IOException {

        // 定义一个DatagramSocket监听8080端口
        DatagramSocket datagramSocket = new DatagramSocket(8080);

        byte[] bytes = new byte[1024];

        // 定义一个数据包,用来接受数据
        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);

        while(true) {
            // 调用datagramScoket的方法receive,会将datagramSocket接受到的数据,存到datagramPacket中
            datagramSocket.receive(datagramPacket);

            String hostName = datagramPacket.getAddress().getHostName();

            // 根据datagramPacket获得的字节,创建字符串
            String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

            System.out.println(data+"---from:"+hostName);
        }

    }

}
