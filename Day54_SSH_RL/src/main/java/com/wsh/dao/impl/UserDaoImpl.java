package com.wsh.dao.impl;

import com.wsh.dao.UserDao;
import com.wsh.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{


    private String sql;

    public List<User> queryAll() {
        sql = "from User";
        List<User> users = (List<User>) getHibernateTemplate().find(sql);
        return users;
    }

    public User queryByUid(int uid) {
        User user = getHibernateTemplate().get(User.class, uid);
        return user;
    }

    public User queryByUsername(String username) {
        sql = "from User u where u.username = ?";
        List<?> user = getHibernateTemplate().find(sql, username);
        return user.size() > 0 ? (User) user.get(0) : null;
    }

    public void insertOrUpdate(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    public void delete(User user) {
        getHibernateTemplate().delete(user);
    }

}
