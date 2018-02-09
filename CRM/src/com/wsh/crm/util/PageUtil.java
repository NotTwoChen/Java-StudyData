package com.wsh.crm.util;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class PageUtil {

    public static <T> List<T> query(Session session,String hql,PageBean pageBean){
        Query query = session.createQuery(hql);
        query.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize());
        List<T> list = query.list();
        return list;
    }
}
