package com.wsh;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    private static String [] names = {
            "王森浩",
            "李国易",
            "袁营营",
            "李想",
            "牛宜生",
            "曾繁昌",
            "熊志祥",
            "石水山",
            "刘鹏",
            "蔡林",
            "许寒",
            "杜大文",
            "赖瑞",
            "郑奎",
            "鲜于春来",
            "陈凯成",
            "董加丰",
            "李晓楠",
            "陈朝雄",
            "徐超",
            "胡凯",
            "杨潇",
            "范文杰",
            "王韬",
            "叶沛颖",
            "严宇丛",
            "刘鑫",
            "冯文",
            "沈世伟",
            "陈宏港"
    };
    public static void main(String[] args) {
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        int length = names.length;
        for (int i = 0; i < length; i++) {
            list1.add(names[i]);
            list2.add(names[i]);
        }
        for (int i = 0; i < list1.size();) {
            int a = (int) (Math.random() * list1.size());
            int b = (int) (Math.random() * list2.size());
            Object name1 = list1.get(a);
            Object name2 = list2.get(b);
            if (name1.equals(name2)){
                continue;
            }
            System.out.println(name1 + "批改     " + name2 + "的作业");
            list1.remove(name1);
            list2.remove(name2);
        }
    }




}
