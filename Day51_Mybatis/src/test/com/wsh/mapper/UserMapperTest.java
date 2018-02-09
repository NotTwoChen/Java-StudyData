package com.wsh.mapper;

import com.wsh.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserMapperTest {

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void findUserById() throws Exception {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(12);
        System.out.println(user);
    }

    @Test
    public void findUsersByName() throws Exception {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findUsersByName("嘤");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws Exception {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(0, "嘤嘤嘤", "女", new Date(), "金融港");
        mapper.insertUser(user);
        findUsersByName();
    }

    @Test
    public void findUserByIdResultMap() throws Exception {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserByIdResultMap(12);
        System.out.println(user);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

}