package com.wsh.crm.post.dao.impl;

import com.wsh.crm.department.domain.CrmDepartment;
import com.wsh.crm.post.dao.PostDao;
import com.wsh.crm.post.domain.CrmPost;
import com.wsh.crm.util.PageBean;
import com.wsh.crm.util.PageUtil;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postDao")
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

    @Override
    public List<CrmPost> findByDepId(String depId) {
        List<CrmPost> posts = (List<CrmPost>) getHibernateTemplate().find("from CrmPost p where p.crmDepartment.depId=?", depId);
        return posts;
    }

    @Override
    public List<CrmPost> findAll() {
        List<CrmPost> posts = (List<CrmPost>) getHibernateTemplate().find("from CrmPost ");
        return posts;
    }

    @Override
    public CrmPost queryByPostId(String postId) {
        return getHibernateTemplate().get(CrmPost.class,postId);
    }

    @Override
    public void update(CrmPost crmPost) {
        CrmPost crmPost1 = queryByPostId(crmPost.getPostId());
        crmPost1.setPostName(crmPost.getPostName());
        getHibernateTemplate().update(crmPost1);
    }

    @Override
    public void insert(CrmPost crmPost) {
        CrmDepartment crmDepartment = getHibernateTemplate().get(CrmDepartment.class, crmPost.getCrmDepartment().getDepId());
        crmPost.setCrmDepartment(crmDepartment);
        getHibernateTemplate().save(crmPost);
    }

    @Override
    public List<CrmPost> findAll(PageBean<CrmPost> pageBean) {
        String hql = "from CrmPost";
        return getHibernateTemplate().execute(session -> {
            return PageUtil.query(session,hql,pageBean);
        });
    }
}
