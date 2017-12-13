package com.wsh.study;

import org.junit.Test;

import java.io.*;

public class BufferDemo {

    @Test
    public void showRead() throws IOException {
        FileReader fileReader = new FileReader("src/周报(三).txt");

        // 将字符读取流传到构造方法中
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;

        StringBuffer stringBuffer = new StringBuffer();
        // readLine 方法,一读读一行
        // 如果什么都没有读到
        // 返回null
        while((line = bufferedReader.readLine()) != null){
            // 将读取到的内容,添加到StringBuffer中
            stringBuffer.append(line+"\n");
        }
        System.out.println(stringBuffer);
    }

    @Test
    public void showWriter() throws IOException {
        FileWriter fileWriter = new FileWriter("src\\showWriter.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (int i = 0; i < 20; i++) {

            bufferedWriter.write(i+"");
            bufferedWriter.newLine();// 新写一行
        }
        bufferedWriter.flush();// 将流中的内容刷新到文件


    }
}
