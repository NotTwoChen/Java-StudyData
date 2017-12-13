package com.wsh.study;

import com.wsh.study.component.*;
import com.wsh.study.decorator.*;

public class Main {
    public static void main(String[] args) {
        // 来杯可乐
        可乐Component 可乐Component = new 可乐Component();
        // 兑点水
        兑水Decorator 兑水Decorator = new 兑水Decorator(可乐Component);

        System.out.println(兑水Decorator.getName()+ 兑水Decorator.price());

        加醋Decorator 加醋Decorator = new 加醋Decorator(兑水Decorator);

        System.out.println(加醋Decorator.getName()+加醋Decorator.price());

    }



}

