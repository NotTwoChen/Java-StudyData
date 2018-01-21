package com.wsh.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TeacherTest {


    @Test
    public void save(){
        // 创建一个装载配置信息的对象
        Configuration configuration = new Configuration();
        // 将hibernate.cfg.xml中的信息装进去
        Configuration configure = configuration.configure();
        // 根据配置信息创建一个sessionFactory
        // sessionFactory负责创建Session
        SessionFactory sessionFactory = configure.buildSessionFactory();
        // 开启一个session
        // 在hibernate中,session就相当于jdbc中的connection
        Session session = sessionFactory.openSession();
        // 获取事务对象
        Transaction transaction = session.getTransaction();
        // hibernate默认是不自动提交事务的
        // 先开启事务
        transaction.begin();
        // 构建一个要保存的teacher对象
        // 因为tid是主键,并且设置了自增长
        // 所以我们不需要设置主键
        Teacher teacher = new Teacher();
        teacher.setName("我是你爸爸");
        teacher.setAge(123);
        teacher.setSubject("男子单人打");
        // session就相当于connection
        // 也就是说增删改查方法都session调用的
        session.save(teacher);
        // 提交事务
        // 如果不提交事务,则上述保存操作
        // 并不会更新到数据库
        transaction.commit();
        // session相当于连接,使用后需要关闭
        session.close();
    }

}