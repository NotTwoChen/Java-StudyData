package com.lanou3g.RLFunction.works;

import com.lanou3g.RLFunction.userdata.Person;
import com.lanou3g.RLFunction.userInter.UserInter;

public class Boss extends Person implements UserInter {
    public Boss(String name, String username, String password, String worker) {
        super(name, username, password, worker);
    }

    @Override
    public void onLine() {
        System.out.println(this.getName() + "一大早就准备开会了!");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println();
        selfOnLine();
    }

    @Override
    public void offLine() {
        System.out.println(this.getName() + "卡都不打就下班了!");
    }

    public void selfOnLine(){
        System.out.println(this.getName() + "觉得今天工作不错,决定发工资了!");
    }
}
