package com.lanou3g.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        /**
         *  第一题:
         */
//        // 可以生的兔子
//        int a = 0;
//        // 准备生的兔子
//        int b = 0;
//        // 不可生的兔子
//        int c = 1;
//        // 月份
//        for (int time = 1; time < 47; time++) {
//            if (time >1) {
//                a = a + b;
//                b = c;
//                c = a;
//            }
//            System.out.println("第"+time+"个月,兔子对数为:"+(a+b+c));
//        }
        /**
         *  第二题:
         */
//        for (int i = 101;i <= 200; i++) {
//            boolean b = false;
//            for (int j = 2; j < i-1; j++) {
//                if (i%j==0){
//                    b = true;
//                    break;
//                }
//            }
//            if (b == false){
//                System.out.println("素数:"+i);
//            }
//        }
        /**
         * 第三题:
         */
//        for (int i = 1; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                for (int k = 0; k < 10; k++) {
//                    if (((i*i*i)+(j*j*j)+(k*k*k)) == ((i*100)+(j*10)+k)){
//                        System.out.println((i*100)+(j*10)+k);
//                    }
//                }
//            }
//        }
        /**
         * 第四题:
         */
//        Scanner scanner = new Scanner(System.in);
//        int input = scanner.nextInt();
//        List list = new ArrayList();
//        boolean b = true;
//        while(b){
//            int i = 0;
//            if (input == 2){
//                list.add(input);
//                b = false;
//                continue;
//            }
//            for (i = 2; i <= input-1; i++) {
//                if (input % i == 0){
//                    list.add(i);
//                    input/=i;
//                    i = input;
//                    continue;
//                }
//                if (i == input-1){
//                    list.add(input);
//                    b = false;
//                    continue;
//                }
//            }
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        /**
         * 第五题:
         */

    }
}
