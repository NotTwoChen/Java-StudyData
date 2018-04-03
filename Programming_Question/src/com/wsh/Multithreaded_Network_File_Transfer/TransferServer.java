package com.wsh.Multithreaded_Network_File_Transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 王森浩 on 2018/3/28 16:36
 */
public class TransferServer {

    private int defaultBindPort = Constants.DEFAULT_BIND_PORT; // 默认监听端口号为10000

    private int tryBindTimes = 0; // 初识的绑定端口的次数设定为0

    private ServerSocket serverSocket; // 服务套接字等待对方的连接和文件发送

    private ExecutorService executorService; // 线程池

    private final int POOL_SIZE = 4; // 单个CPU的线程池大小

    /**
     *  不带参数的构造器，选用默认的端口号
     * @throws Exception
     */
    public TransferServer() throws Exception {
        try {
            this.bingToServerPort(defaultBindPort);
            executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
            System.out.println("开辟线程数： " + Runtime.getRuntime().availableProcessors() * POOL_SIZE);
        } catch (Exception e) {
            throw new Exception("绑定端口不成功！");
        }
    }

    /**
     *  带参数的构造器，选用用户指定的端口号
     * @param port
     */
    public TransferServer(int port) throws Exception {
        try {
            this.bingToServerPort(port);
            executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
        } catch (Exception e) {
            throw  new Exception("绑定端口不成功！");
        }
    }

    private void bingToServerPort(int port) throws Exception {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println(port);
            System.out.println("服务启动！");
        } catch (IOException e) {
            this.tryBindTimes = this.tryBindTimes + 1;
            port = port + this.tryBindTimes;
            if (this.tryBindTimes >= 20) {
                throw new Exception("您已经尝试很多次了，但是仍无法绑定到指定的端口！请重新选择绑定的默认端口号！");
            }
            // 递归绑定端口
            this.bingToServerPort(port);
        }
    }

    public void service(){
        Socket socket = null;
        while (true){
            try {
                socket = serverSocket.accept();
                executorService.execute(new Handler(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class  Handler implements Runnable{

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());

            DataInputStream dis = null;
            DataOutputStream dos = null;

            int bufferSize = 8192;
            byte[] buf = new byte[bufferSize];

            try {
                dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                String savePath = Constants.RECEIVE_FILE_PATH + dis.readUTF();
                long length = dis.readLong();
                dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(savePath)));

                int read = 0;
                long passedlen = 0;
                while ((read = dis.read(buf))!= -1) {
                    passedlen += read;
                    dos.write(buf,0,read);

                    System.out.println("文件[" + savePath + "]已经接受：" + passedlen * 100L / length + "%");
                }
                System.out.println("文件：" + savePath + "接受完成！");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("接受文件失败！");
            }finally {
                try {
                    if (dos != null){
                        dos.close();
                    }
                    if (dis != null){
                        dis.close();
                    }
                    if (socket != null){
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new TransferServer().service();
    }
}
