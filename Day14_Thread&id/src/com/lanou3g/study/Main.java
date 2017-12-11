package com.lanou3g.study;

public class Main {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        ThreadDemo t1 = new ThreadDemo("测试",ticket);

        t1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket.continued();
                }
            }
        }).start();
    }
}
