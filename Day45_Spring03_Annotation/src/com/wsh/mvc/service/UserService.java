package com.wsh.mvc.service;

import com.wsh.mvc.bean.User;
import com.wsh.mvc.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao ud = (UserDao) UserDao.getContext().getBean("userDao");

    public User query(User form){
        User query = ud.query();
        return query;
    }
}
