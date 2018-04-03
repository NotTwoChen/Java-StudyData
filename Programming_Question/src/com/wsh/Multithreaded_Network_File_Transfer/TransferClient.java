package com.wsh.Multithreaded_Network_File_Transfer;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 王森浩 on 2018/3/28 17:00
 */
public class TransferClient {

    private static ArrayList<String> fileList = new ArrayList<>();

    private String sendFilePath = Constants.SEND_FILE_PATH;


    /**
     *  带参数的构造器，用户设定需要传送文件的文件夹
     * @param filePath
     */
    public TransferClient(String filePath) {
        getFilePath(filePath);
    }

    /**
     *  不带参数的构造器，使用默认的传送文件的文件夹
     */
    public TransferClient() {
        getFilePath(sendFilePath);
    }

    public void service(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Vector<Integer> vector = getRandom(fileList.size());
        for (Integer integer : vector) {
            String filePath = fileList.get(integer.intValue());
            executorService.execute(sendFile(filePath));
        }
    }

    private void getFilePath(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()){
                getFilePath(files[i].getAbsolutePath());
            }else {
                fileList.add(files[i].getAbsolutePath());
            }
        }
    }

    private Vector<Integer> getRandom(int size){
        Vector<Integer> vector = new Vector<>();
        Random random = new Random();
        boolean b = true;
        while (b){
            int i = random.nextInt(size);
            if (!vector.contains(i))
            vector.add(i);
            if (vector.size() == size)
                b = false;
        }
        return vector;
    }

    private static Runnable sendFile(final String filePath){
        return new Runnable() {
            private Socket socket = null;
            private String ip = "localhost";
            private int port = 10000;

            @Override
            public void run() {
                System.out.println("开始发送文件：" + filePath);
                File file = new File(filePath);
                if (createConnection()) {
                    int bufferSize = 8192;
                    byte[] buf = new byte[bufferSize];
                    try {
                        DataInputStream fis = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                        dos.writeUTF(file.getName());
                        dos.flush();
                        dos.writeLong(file.length());
                        dos.flush();

                        int read = 0;
                        int passedlen = 0;
                        long length = file.length(); // 获得要发送文件的长度
                        while ((read = fis.read(buf)) != -1) {
                            passedlen += read;
                            System.out.println("已经完成文件[" + file.getName() + "]百分比：" + passedlen * 100L / length + "%");
                            dos.write(buf, 0, read);
                        }

                        dos.flush();
                        fis.close();
                        dos.close();
                        socket.close();
                        System.out.println("文件 " + filePath + "传输完成！");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            private boolean createConnection(){
                try {
                    socket = new Socket(ip,port);
                    System.out.println("连接服务器成功！");
                    return true;
                } catch (IOException e) {
                    System.out.println("连接服务器失败！");
                    return false;
                }
            }
        };
    }

    public static void main(String[] args) {
        new TransferClient().service();
    }
}
