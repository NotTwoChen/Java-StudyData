package com.wsh.study;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("src/text.txt");

        fileWriter.write("野草烧不尽,春风吹又生!!!");

        fileWriter.close();
    }
}
