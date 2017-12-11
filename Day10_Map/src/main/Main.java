package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         *  Map是什么?
         *  是一个接口
         *  Map也可以存放数据
         *  Map存放的数据,都是键值对形式的
         *  什么是键值对?
         *
         *          name = "zhangSan"
         *          age = 1
         *          gender = "男"
         *    这种一一对应的关系,就叫做键值对
         */

        List list = new ArrayList();
        list.add("张三");
        list.add("李四");
        System.out.println(Arrays.toString(list.toArray()));


        // shift+F6 全部修改
        Map map = new HashMap();
        // 键-值对      key-value

        // put方法,向map中添加信息
        // 括号中接受两个参数
        // 第一个参数表示key(键)
        // 第二个参数表示value(值)
        map.put("name","张三");//键相同,值覆盖
        map.put("name","李四");
        map.put("gender","男");
        map.put("age",3);
        map.put("money",10000);
        map.put("wife","李大婶");
        map.put("brother","李老八");


        first(map);

        second(map);

        Iterate(map);


    }

    private static void first(Map map) {
        System.out.println("遍历map的第一种方式!");
        // iter 迭代数组
        // 遍历map的第一种方式
        for (Object o : map.keySet()) {
            // map.keySet就是将map中所有的key拿出来
            // 增强for循环,也叫foreach

            // ":"后面,接受的是一个集合
            //              也就是接受了一堆数据
            System.out.println(o.toString() + map.get(o).toString());
            System.out.println(map.get(o).toString());
        }
    }

    private static void second(Map map) {
        // 遍历map的第二种方式
        System.out.println("遍历map的第二种方式!");
        // 获得map这个map中所有的键值对
        // 放进了这个set集合中
        Set set = map.entrySet();
        /**
         *  Collection是一个接口
         *  List和Set都是Collection的子接口
         *
         *  我们使用的集合ArrayList只是List的一个实现类
         *
         *  List:有序(通过角标找元素),可重复
         *  Set:无序,不可重复
         */
        for (Object o : set) {
            //  o这个引用指向的对象的类型为:HashMap$Node
            // 但是这里我们将o强转成Map.Entry的时候,还不报错

            // HashMap$Node是Map.Entry的实现类

            // 一个Entry的实线类对象,就表示一个键值对
            // 可以使用这个对象,获得key和value

            Map.Entry entry = (Map.Entry) o;
            System.out.println("key的值为:"+entry.getKey()
                    +"\nvalue的值为:"+entry.getValue());
//            System.out.println(o.getClass().getName());
        }
    }

    private static void Iterate(Map map) {
        // 迭代器 Iterator
        System.out.println("遍历map的第三种方式!\n开始使用迭代器遍历map集合");
        Iterator iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            // 如果有下一个,则返回true,进入到while循环

            // 获得的对象,是Object类型的
            // 父类的引用next,只能使用父类的方法
            // 无法使用子类独有的方法
            Object next = iterator.next();

            // 所以要把next强转成子类
            Map.Entry entry = (Map.Entry)next;

            System.out.println("key为:" + entry.getKey()
                    + "\nvalue为:" + entry.getValue());

        }
    }
}
