package com.lanou3g.study;

public class HelloRunnable implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 111111; i++) {
            System.out.println("Hello runnable:" + i);
        }
    }
}
