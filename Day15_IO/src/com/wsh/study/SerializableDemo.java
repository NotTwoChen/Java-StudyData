package com.wsh.study;

import org.junit.Test;

import java.io.*;

public class SerializableDemo {

    @Test
    public void input() throws IOException {
        Object pet = new Pet();
        FileInputStream fileInputStream = new FileInputStream("src/pet.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Object object = objectInputStream.readObject();
    }

    @Test
    public void output() throws IOException {

        Pet pet = new Pet("雪纳瑞","male");

        FileOutputStream fileOutputStream = new FileOutputStream("src/pet.out");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(pet);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
