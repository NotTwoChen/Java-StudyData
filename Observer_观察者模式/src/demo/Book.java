package demo;

import java.lang.reflect.Method;

public class Book extends Observable {
    private String name;
    private static Book instance = null;
    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }
    public static synchronized Book getInstance(){
        if (instance == null){
            instance = new Book();
        }
        return instance;
    }

    @Override
    public void notifyObservers(Object... objects) {
        for (Class<?> aClass : observerList) {
            notifyObserver(aClass,objects);
        }
    }

    @Override
    public void notifyObserver(Class<?> clazz, Object... objects) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("update")){
                try {
                    Reader reader = (Reader) clazz.newInstance();
                    method.invoke(reader,objects);
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public <T> void notifyObserver(T t, Object... objects) {
        notifyObserver(t.getClass(),objects);
    }
}
