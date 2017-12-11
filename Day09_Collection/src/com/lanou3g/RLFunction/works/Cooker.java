package com.lanou3g.RLFunction.works;

import com.lanou3g.RLFunction.userdata.Person;
import com.lanou3g.RLFunction.userInter.UserInter;

public class Cooker extends Person implements UserInter {
    public Cooker(String name, String username, String password, String worker) {
        super(name, username, password, worker);
    }

    @Override
    public void onLine() {
        System.out.println(this.getName() + "准备食材做饭了!");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(150);
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
        System.out.println(this.getName() + "吃饱喝足回家睡觉!");
    }

    public void selfOnLine(){
        System.out.println(this.getName() + "是从新东方出来的,觉得自己不应该局限在这里!");
    }
}
