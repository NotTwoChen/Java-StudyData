package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) {
//        first();

//        second();

//        third();
        List<Rice> 饭桶一号 = new ArrayList<>();
        饭桶一号.add(new Rice("盘锦大米"));

        List<Rice> 饭桶二号 = new ArrayList<>();
        饭桶二号.add(new Rice("热干面"));

        Map<String,List<Rice>> map = new HashMap<>();

        map.put("一号",饭桶一号);
        map.put("二号",饭桶二号);

        for (String s : map.keySet()) {
            List<Rice> rice = map.get(s);
            for (int i = 0; i < rice.size(); i++) {
                System.out.println(rice.get(i));
            }
        }

    }

    private static void third() {
        List<Rice> 饭桶一号 = new ArrayList<>();
        饭桶一号.add(new Rice("盘锦大米"));

        List<Rice> 饭桶二号 = new ArrayList<>();
        饭桶二号.add(new Rice("热干面"));

        List<List<Rice>> 饭库 = new ArrayList<>();

        饭库.add(饭桶一号);
        饭库.add(饭桶二号);

        for (int i = 0; i < 饭库.size(); i++) {
            List<Rice> 饭桶 = 饭库.get(i);
            for (int j = 0; j < 饭桶.size(); j++) {
                Rice rice = 饭桶.get(j);
                System.out.println(rice);
                System.out.println(饭桶.get(j).getName());
            }
        }
    }

    private static void second() {
        Map<String,Student> map = new HashMap<>();

        map.put("张三",new Student());

        Student 张三 = map.get("张三");
    }

    private static void first() {
        /**
         *  泛型
         */
        // 思想:  面向接口编程
        List<String> list = new ArrayList<>();

        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");

        // 增强for循环中,是不可以改变集合中的元素的
        for (String s: list) {
            s = "周吴郑王";
//            System.out.println(s);
        }

        for (String s : list) {
            System.out.println(s);

        }
    }
}
