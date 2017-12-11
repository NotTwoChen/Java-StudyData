package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("name","张三");
        map.put("gender","男");
        map.put("age",18);
        System.out.println("第一种遍历方式");
        for (Object o :map.keySet()){
            System.out.println("key:"+o+"\nvalue:"+map.get(o));
        }
        System.out.println("第二种遍历方式");
        for (Object o :map.values()){
            System.out.println("value:"+o);
        }
        System.out.println("第三种遍历方式");
        Set set = map.entrySet();
        for (Object o : set){
            Map.Entry entry = (Map.Entry) o;
            System.out.println("key:"+entry.getKey()+"\nvalue:"+entry.getValue());
        }
        System.out.println("第四种遍历方式");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println("key:"+entry.getKey()+"\nvalue:"+entry.getValue());
        }
    }
}
