package com.lanou3g.yesterday;

import com.lanou3g.yesterday.one.DataBaseUtil;
import com.lanou3g.yesterday.one.Student;
import com.lanou3g.yesterday.one.Teacher;

public class Main {
    public static void main(String[] args) {
        DataBaseUtil<Student> dataBaseUtil = new DataBaseUtil<>();

        dataBaseUtil.save(new Student());

        DataBaseUtil<Teacher> dataBaseUtil1 = new DataBaseUtil<>();

        dataBaseUtil1.save(new Teacher());





    }
    // 如果返回值的类型是任意的,就将void改成T
    // 如果接受的类型是任意的,就在方法名后的括号里写T t
    public static <T> void test(T t){

    }
    public static <E> E test2(){
        return null;
    }
}
