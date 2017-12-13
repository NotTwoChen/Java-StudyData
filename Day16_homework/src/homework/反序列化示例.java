package homework;

import java.io.*;

public class 反序列化示例 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("src/");

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object object = objectInputStream.readObject();

        System.out.println(object);

        objectInputStream.close();


    }



}
