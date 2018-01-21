package com.wsh.bean;

import com.wsh.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ClazzTest {

    /**
     * 通过debug我们发现,在执行save方法后
     * 缓存map中,出现了两条数据
     *
     * 所以我们可以知道,save方法可以将数据保存到缓存中
     */
    @Test
    public void save(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Clazz clazz = new Clazz();
        clazz.setCid(2);
        clazz.setCname("四年二班");
        Clazz clazz2 = new Clazz();
        clazz2.setCid(3);
        clazz2.setCname("三年二班");
        Transaction transaction = session.beginTransaction();
        session.save(clazz);
        session.save(clazz2);
        transaction.commit();
        Transaction transaction1 = session.beginTransaction();
        Clazz clazz1 = session.get(Clazz.class, 1);
        System.out.println(clazz1.toString());
        transaction1.commit();
        session.close();
    }

    @Test
    public void get(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Clazz clazz = session.get(Clazz.class, 2);
        System.out.println(clazz);
        transaction.commit();
        session.close();
    }
    @Test
    public void evict(){
        HibernateUtil.handle(new HibernateUtil.ResultHandle<Clazz>() {
            @Override
            public Clazz resultHandle(Session session) {
                // 这里这个get会将找到的班级对象,存入缓存中
                Clazz clazz = session.get(Clazz.class, 2);
                // evict方法,会将这个班级对象从缓存中移除
                session.evict(clazz);
                // 缓存中没有这个对象了,再次get,会去数据库再查一遍
                session.get(Clazz.class,2);
                return null;
            }
        });
    }
    @Test
    public void oneToMany1(){
        HibernateUtil.handle(session -> {
            Student student1 = new Student("张三");
            Student student2 = new Student("李四");
            Student student3 = new Student("王五");
            Student student4 = new Student("赵六");
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);
            Clazz clazz = new Clazz("四年四班");
            clazz.getStudents().add(student1);
            clazz.getStudents().add(student2);
            clazz.getStudents().add(student3);
            clazz.getStudents().add(student4);
            session.save(clazz);
            return null;
        });
    }
    @Test
    public void oneToMany2(){
        Clazz handle = HibernateUtil.handle(session -> {
            Student student1 = new Student("周七");
            Student student2 = new Student("吴八");
            Clazz clazz = new Clazz("五年二班");
            clazz.getStudents().add(student1);
            clazz.getStudents().add(student2);
            // 因为设置了级联属性为save-update
            // 所以保存班级时,也会级联保存学生
            session.save(clazz);
            return clazz;
        });
        System.out.println(handle.toString());
    }
    @Test
    public void oneToMany3(){
        HibernateUtil.handle(session -> {
            Clazz clazz = session.get(Clazz.class, 6);
//            clazz.getStudents().add(new Student("陈不三"));
//            clazz.getStudents().add(new Student("陈不四"));
            System.out.println(Arrays.toString(clazz.getStudents().toArray()));
            System.out.println(clazz);
            return clazz;
        });
    }
    @Test
    public void oneToMany4(){
        HibernateUtil.handle(session -> {
            Clazz clazz = session.get(Clazz.class, 2);
            // 给两个学生一个班级对象
            Student student1 = new Student("张三丰");
            student1.setClazz(clazz);
            Student student2 = new Student("李隆基");
            student2.setClazz(clazz);
            session.save(student1);
            session.save(student2);
            return null;
        });
    }

    @Test
    public void validateSecond(){
        HibernateUtil.handle(session -> {
            Clazz clazz = session.get(Clazz.class, 1);
            // 这里,发现一级缓存中有该数据
            // 则直接从一级缓存中获取,不再查找数据库
            clazz = session.get(Clazz.class,1);
            return null;
        });
        HibernateUtil.handle(session -> {
            // 这里,已经不再是上一个session了
            // 是一个新的session了
            // 所以一级缓存中,肯定没数据
            // 那么去二级缓存中找,也找到了
            // 所以也不会去查找数据库了
            Clazz clazz = session.get(Clazz.class, 1);
            return null;
        });
    }
    @Test
    public void query(){
        HibernateUtil.handle(session -> {
            // from 后面跟着的是类的全名
            Query query = session.createQuery("from " + Clazz.class.getName());
            List<Clazz> list = query.list();
            for (Clazz clazz : list) {
                System.out.println(clazz);
            }
            // 输出,二级缓存中的数据总数
            // 这个得在配置文件中,配置开启二级缓存统计
            System.out.println(session.getSessionFactory().getStatistics().getEntityLoadCount());

            return null;
        });
    }
    @Test
    public void queryCache(){
        HibernateUtil.handle(session -> {
            Query query = session.createQuery("from " + Clazz.class.getName());
            // 手动开启查询缓存
            query.setCacheable(true);
            List list = query.list();
            System.out.println(Arrays.toString(list.toArray()));
            return null;
        });
    }

}