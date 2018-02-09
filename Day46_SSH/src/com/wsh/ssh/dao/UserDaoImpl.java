package com.wsh.ssh.dao;

import com.wsh.ssh.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public void add(User form) {
        getHibernateTemplate().save(form);
    }

    @Override
    public void delete(User form) {
        getHibernateTemplate().delete(form);
    }

    @Override
    public void update(User form) {
        getHibernateTemplate().update(form);
    }

    @Override
    public User query(String username) {
        List<User> list = (List<User>) getHibernateTemplate().find("from User u where u.username=?", username);
        if (list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
