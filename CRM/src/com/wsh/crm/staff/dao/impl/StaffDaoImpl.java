package com.wsh.crm.staff.dao.impl;

import com.wsh.crm.post.domain.CrmPost;
import com.wsh.crm.staff.dao.StaffDao;
import com.wsh.crm.staff.domain.CrmStaff;
import com.wsh.crm.util.MD5_UUID_Util;
import com.wsh.crm.util.PageBean;
import com.wsh.crm.util.PageUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * StaffDao的实现类
 */
@Repository("staffDao")
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    @Override
    public void insert(CrmStaff staff) {
        CrmPost crmPost = getHibernateTemplate().get(CrmPost.class, staff.getCrmPost().getPostId());
        staff.setCrmPost(crmPost);
        getHibernateTemplate().save(staff);
    }

    @Override
    public void delete(CrmStaff staff) {
        getHibernateTemplate().delete(staff);
    }

    @Override
    public void update(CrmStaff staff) {
        getHibernateTemplate().update(staff);
    }

    @Override
    public CrmStaff query(String loginName, String loginPwd) {
        String sql = "from CrmStaff where loginName = ? and loginPwd = ?";
        List<?> crmStaffs = getHibernateTemplate().find(sql, loginName, loginPwd);
        if (crmStaffs.size() > 0){
            return (CrmStaff) crmStaffs.get(0);
        }
        return null;
    }

    @Override
    public CrmStaff queryByLoginName(String loginName){
        List<CrmStaff> crmStaffs = (List<CrmStaff>) getHibernateTemplate().find("from CrmStaff s where s.loginName=?", loginName);
        if (crmStaffs.size() > 0){
            return crmStaffs.get(0);
        }
        return null;
    }

    @Override
    public CrmStaff queryByStaffId(String staffId) {
        List<CrmStaff> crmStaffs = (List<CrmStaff>) getHibernateTemplate().find("from CrmStaff s where s.staffId = ?", staffId);
        if (crmStaffs.size() > 0){
            return crmStaffs.get(0);
        }
        return null;
    }

    @Override
    public List<CrmStaff> queryAll() {
        List<CrmStaff> crmStaffs = (List<CrmStaff>) getHibernateTemplate().find("from CrmStaff");
        return crmStaffs;
    }
    @Override
    public List<CrmStaff> queryAll(String hql,PageBean pageBean){
        return getHibernateTemplate().execute(session -> {
            return PageUtil.query(session,hql,pageBean);
        });
    }
    @Override
    public List<CrmStaff> queryAll(String sql) {
        List<CrmStaff> crmStaffs = (List<CrmStaff>) getHibernateTemplate().find(sql);
        return crmStaffs;
    }




}
