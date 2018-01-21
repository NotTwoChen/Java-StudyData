package com.wsh.bean;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class StudentTest {
    //  快速删除类中无用的import
    // alt + ctrl + o

    @Test
    public void hello(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    }
    @Test
    //保存
    public void save(){

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student=new Student();
        student.setSid(1);
        student.setName("猴子");
        student.setAge(200);
        student.setGender("男");


        session.save(student);
        //
        session.getTransaction().commit();
        session.close();

    }
    @Test
    public void get(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        // 通过id找到对应的数据
        Student student = session.get(Student.class, 1L);
        Student student1 = session.get(Student.class, 1L);
        //  脱管/驱逐
        // 将student1指向的对象,从持久化转为游离
        // 此时hibernate也就不再维护该对象的状态
        // 什么叫维护
        // 只要一个对象处于持久化状态中,
        // hibernate就会保证她的属性值与数据库中的一致
        session.evict(student1);
        student1.setName("王五");
        Student student2 = session.get(Student.class, 1L);
        System.out.println(student1 == student2);
        System.out.println(student == student1);
        System.out.println(student);
        System.out.println(student2);
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void update(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, 1L);
        student.setName("大王");
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void delete(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, 1L);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void flush(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student1 = session.get(Student.class, 1L);
        Student student2 = session.get(Student.class, 2L);
        student2.setName("我是谁");
        Student student3 = new Student(1,"你好呀",33,"男");
        session.save(student3);
        session.flush();
        transaction.commit();
        session.close();
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
    public void get2(){

    }
}