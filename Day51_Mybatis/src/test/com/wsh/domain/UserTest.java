package com.wsh.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class UserTest {


    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User(0,"李国易","男",new Date(),"金融港");

        // 把配置文件中的信息封装成一个对象
        sqlSession.insert("user.insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectUser() throws Exception {
        List<Object> objects = sqlSession.selectList("user.selectByName", "王");
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    @Test
    public void deleteUser() throws Exception {
        sqlSession.delete("user.deleteUser",3);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User(12, "陈不二", "男", new Date(), "金融港");
        sqlSession.update("user.updateUser",user);
    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }
}