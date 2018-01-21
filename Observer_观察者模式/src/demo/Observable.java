package demo;

import java.util.ArrayList;

/**
 * 被观察者(一个抽象类,而不是一个接口,是为了更方便的扩展)
 */
public abstract class Observable {

    // 被观察者中最关键最核心的一个属性
    // 即用来存放所有观察者的集合
    public final ArrayList<Class<?>> observerList = new ArrayList<Class<?>>();

    // 通过实例化对象添加观察者
    public <T> void addObserver(T observable){
        observerList.add(observable.getClass());
    }
    // 通过Class添加观察者,在未获取到实例对象的时候使用
    private void addObserver(Class<?> clazz){
        synchronized (observerList){
            if (observerList.contains(clazz)){
                observerList.add(clazz);
            }
        }
    }
    // 通过实例化对象删除观察者
    public <T> void deleteObserver(T observable){
        deleteObserver(observable.getClass());
    }
    // 通过Class删除观察者
    private void deleteObserver(Class<?> clazz){
        synchronized (observerList){
            for (Class<?> aClass : observerList) {
                if (aClass.getName().equals(clazz.getName())){
                    observerList.remove(aClass);
                    return;
                }
            }
        }
    }
    // 删除所有观察者
    public void deleteObservers(){
        synchronized (observerList){
            observerList.clear();
        }
    }
    // 计算观察者总数量,即计算观察者集合长度
    public int countObservers(){
        synchronized (observerList){
            return observerList.size();
        }
    }
    // 通知所有观察者,必须在子类中实现
    public abstract void notifyObservers(Object...objects);

    // 通知指定的观察者
    public abstract void notifyObserver(Class<?> clazz,Object...objects);
    public abstract <T> void notifyObserver(T t,Object...objects);


}
