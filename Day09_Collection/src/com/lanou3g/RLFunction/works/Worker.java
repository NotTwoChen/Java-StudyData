package com.lanou3g.RLFunction.works;

import com.lanou3g.RLFunction.userdata.Person;
import com.lanou3g.RLFunction.userInter.UserInter;

public class Worker extends Person implements UserInter {
    public Worker(String name, String username, String password, String work) {
        super(name, username, password, work);
    }

    @Override
    public void onLine() {
        System.out.println(this.getName() + "开始干活了!");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
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
        System.out.println(this.getName() + "干完活回家了!");
    }

    public void selfOnLine(){
        System.out.println(this.getName() + "想了想,搬砖搬砖!还不是一条咸鱼!");
    }
}
