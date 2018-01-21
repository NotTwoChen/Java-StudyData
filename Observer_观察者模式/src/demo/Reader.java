package demo;

import java.util.Arrays;

// 创建book类,实现Observer接口
public class Reader implements Observer {

    private String name;

    public Reader(String name) {
        this.name = name;
    }

    // 实现接口处理
    @Override
    public void update(Object... objects) {
        // 更新数据,UI等
        System.out.println(name+Arrays.toString(objects));
    }
    public void update(Observable observable,Object...objects){
        System.out.println("我到这里来了");
    }

}
