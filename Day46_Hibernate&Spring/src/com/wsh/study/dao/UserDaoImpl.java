package com.wsh.study.dao;

import com.wsh.study.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements  UserDao {

    private User user;

    @Override
    public void add() {
        user = new User("320828748", "320828748");
        this.getHibernateTemplate().save(user);
        System.out.println("-----add-----");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
