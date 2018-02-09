package com.wsh.mapper;

import com.wsh.domain.User;
import com.wsh.domain.UserExt;
import com.wsh.domain.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDynamicMapperTest {

    private UserDynamicMapper userDynamicMapper;
    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        sqlSession = sqlSessionFactory.openSession();
        userDynamicMapper = sqlSession.getMapper(UserDynamicMapper.class);
    }

    @Test
    public void findUsersByQueryVO() throws Exception {
        UserQueryVO userQueryVO = new UserQueryVO();
        UserExt userExt = new UserExt();
//        userExt.setGender("男");
        userExt.setUsername("王");
        userQueryVO.setUserExt(userExt);
        List<User> userExts = userDynamicMapper.findUsersByQueryVO(userQueryVO);
        for (User ext : userExts) {
            System.out.println(ext);
        }
    }

    @Test
    public void findUserCount() throws Exception {
        UserQueryVO userQueryVO = new UserQueryVO();
        UserExt userExt = new UserExt();
//        userExt.setGender("男");
        userExt.setUsername("王");
        userQueryVO.setUserExt(userExt);
        int usersCount = userDynamicMapper.findUsersCount(userQueryVO);
        System.out.println(usersCount);
    }

    @Test
    public void findUserList() throws Exception {
        UserQueryVO userQueryVO = new UserQueryVO();
        UserExt userExt = new UserExt();
        userExt.setGender("女");
        userQueryVO.setUserExt(userExt);
        List<User> userList = userDynamicMapper.findUserList(userQueryVO);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void findUsersCount2() throws Exception {
        UserQueryVO userQueryVO = new UserQueryVO();
        UserExt userExt = new UserExt();
        userExt.setGender("女");
        userQueryVO.setUserExt(userExt);
        int usersCount2 = userDynamicMapper.findUsersCount2(userQueryVO);
        System.out.println(usersCount2);
    }

    @Test
    public void findUsersByQueryVO2() throws Exception {
        UserQueryVO userQueryVO = new UserQueryVO();
        List<Integer> idList = new ArrayList<>();
        idList.add(10);
        idList.add(11);
        idList.add(12);
        userQueryVO.setIdList(idList);
        List<User> userExts = userDynamicMapper.findUserList(userQueryVO);
        for (User ext : userExts) {
            System.out.println(ext);
        }
    }

    @Test
    public void findUsersByIdList() throws Exception {
        List<Integer> idList = new ArrayList<>();
        idList.add(10);
        idList.add(11);
        idList.add(12);
        List<User> list = userDynamicMapper.findUsersByIdList(idList);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

}