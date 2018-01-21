package com.wsh.work.dao;


import com.wsh.util.HibernateUtil;
import com.wsh.work.bean.Staff;
import org.hibernate.Query;

import java.util.List;

public class StaffDao {

    public void add(Staff staff){
        HibernateUtil.handle(session -> {
            session.save(staff);
            return staff;
        });
    }
    public void delete(Staff staff){
        HibernateUtil.handle(session -> {
            session.delete(staff);
            return staff;
        });
    }
    public void update(Staff staff){
        HibernateUtil.handle(session -> {
            session.update(staff);
            return staff;
        });
    }
    public Staff query(int sid){
        Staff handle = HibernateUtil.handle(session -> {
            Staff staff = session.get(Staff.class, sid);
            return staff;
        });
        return handle;
    }
    public List<Staff> queryAll(){
        List<Staff> handle = HibernateUtil.handle(session -> {
            Query query = session.createQuery("from " + Staff.class.getName());
            List<Staff> list = query.list();
            return list;
        });
        return handle;
    }
}
