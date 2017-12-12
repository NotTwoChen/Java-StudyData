package com.wsh.study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyByFile {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("src/text.txt");

        char [] chars = new char[1024];

        // 返回值表示,读了多少字符
        int read = fileReader.read(chars);

        FileWriter fileWriter = new FileWriter("src/text2.txt");

        fileWriter.write(chars,0,read);

        fileWriter.close();
        fileReader.close();


    }
}
