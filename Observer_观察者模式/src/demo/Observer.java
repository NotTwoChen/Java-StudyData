package demo;

/**
 * 观察者,需要用到观察者模式的类实现此接口
 */
public interface Observer {

    // 更新,将被观察者的动态反馈到给观察者
    void update(Object...objects);
}
