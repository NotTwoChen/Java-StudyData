package com.lanou3g.study;

public class HelloThread extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 11111; i++) {
            System.out.println("Hello Thread"+i);
        }
    }
}
