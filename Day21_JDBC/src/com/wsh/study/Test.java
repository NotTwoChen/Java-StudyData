package com.wsh.study;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class c = T.class;
//        System.out.println(c);
        /*
            静态的东西会随着类的加载而进入内存
            所以当我们未创建对象,只是将类加载时
            会执行该类的静态代码块

            而因为类只需要加载一次
            所以再创建T对象时,是不会再次执行静态代码块
         */
        Class<?> aClass = Class.forName("com.wsh.study.T");
        System.out.println(aClass);
        T t = new T();
        System.out.println(t);

    }
}
