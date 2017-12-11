package com.lanou3g.study;

public class Main3 {

    private static int num = 10000;

    public static void main(String[] args) {
//        num = 100000;

        // 调研?
        // 为什么局部变量,在内部类中使用时
        // 一定要用final修饰?

        // 什么叫原子性操作?
        // int a = 1;   是原子性操作
        // int b = a + 1;   不是原子性操作
        // 第一步:取值/第二步:运算/第三步:赋值

        startOneThread();
        startOneThread();
        startOneThread();
        startOneThread();
    }

    private static void startOneThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25000; i++) {
                    System.out.println(--num);
                }
            }
        }).start();
    }


}
