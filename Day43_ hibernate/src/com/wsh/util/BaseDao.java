package com.wsh.util;

public interface BaseDao <T> {

    T add(T t);

    T delete(T t);

    T update(T t);

    T get(Class<T> tClass,long id);

}
