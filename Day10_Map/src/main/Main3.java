package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("name","张三");
        map.put("age",18);
        System.out.println("遍历map的第一种方式");
        for (Object o : map.keySet()) {
            System.out.println("key为:" + o + "\nvalue为:" + map.get(o));
        }
        System.out.println("遍历map的第二种方式");
        Set set = map.entrySet();
        for (Object o : set) {
            Map.Entry entry = (Map.Entry)o;
            System.out.println("key为:" + entry.getKey() + "\nvalue为:" + entry.getValue());
        }
        System.out.println("遍历map的第三种方式");
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println("key为:" + entry.getKey() + "\nvalue为:" + entry.getValue());
        }
        System.out.println("遍历map的第四种方式");
        for (Object o : map.values()) {
            System.out.println(o);
        }


    }
}
