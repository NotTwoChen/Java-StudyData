package com.lanou3g.RLFunction.works;

import com.lanou3g.RLFunction.userdata.Person;
import com.lanou3g.RLFunction.userInter.UserInter;

public class Doctor extends Person implements UserInter {
    public Doctor(String name, String username, String password, String work) {
        super(name, username, password, work);
    }

    @Override
    public void onLine() {
        System.out.println(this.getName() + "戴手套动手术!");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(90);
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
        System.out.println(this.getName() + "累死累活动都懒得动!");
    }

    public void selfOnLine(){
        System.out.println(this.getName() + "拿起手术刀就要开始干活!");
    }
}
