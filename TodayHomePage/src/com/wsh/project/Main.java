package com.wsh.project;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
//        for(int i=0;i<10;i++){
//            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String uuid = uuid();
        System.out.println(uuid);
        System.out.println(uuid);
        System.out.println(uuid);
//            System.out.println(uuid);
//            System.out.println(uuid.getBytes().length);
//        }
    }
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
