package com.wsh.crm.staff.service.impl;

import com.wsh.crm.staff.dao.StaffDao;
import com.wsh.crm.staff.domain.CrmStaff;
import com.wsh.crm.staff.service.StaffService;
import com.wsh.crm.staff.service.exception.NameOrPwdErrorException;
import com.wsh.crm.util.MD5_UUID_Util;
import com.wsh.crm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  staffService的实现类
 */
@Service("StaffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;
    private PageBean<CrmStaff> pageBean;

    @Override
    public CrmStaff login(CrmStaff crmStaff) throws NameOrPwdErrorException {
        crmStaff.setLoginPwd(MD5_UUID_Util.getMd5(crmStaff.getLoginPwd()));
        crmStaff = staffDao.query(crmStaff.getLoginName(),crmStaff.getLoginPwd());
        if (crmStaff == null){
            throw new NameOrPwdErrorException();
        }
        return crmStaff;
    }

    @Override
    public PageBean<CrmStaff> queryAll(int nowPageIndex,String depId, String postId, String staffName) {
        StringBuilder sb = new StringBuilder("from CrmStaff s where 1=1 ");
        Map<String,String> map = new HashMap<>();
        map.put("s.crmPost.crmDepartment.depId",depId);
        map.put("s.crmPost.postId",postId);
        map.put("s.staffName",staffName);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!entry.getValue().equals("")){
                sb.append(" and " + entry.getKey() + "='" + entry.getValue() + "' ");
            }
        }
        List<CrmStaff> crmStaffs = staffDao.queryAll(sb.toString());
        pageBean = new PageBean<>(nowPageIndex,crmStaffs.size());
        crmStaffs = staffDao.queryAll(sb.toString(), pageBean);
        pageBean.setList(crmStaffs);
        return pageBean;
    }

    @Override
    public CrmStaff queryByStaffId(String staffId) {
        return staffDao.queryByStaffId(staffId);
    }

    @Override
    public void editPassword(CrmStaff staff,String newPassword) {
        CrmStaff crmStaff = staffDao.queryByLoginName(staff.getLoginName());
        crmStaff.setLoginPwd(newPassword);
        staffDao.update(crmStaff);
    }

    @Override
    public void updateStaff(CrmStaff crmStaff) {
        staffDao.update(crmStaff);
    }



    @Override
    public void insert(CrmStaff crmStaff) {
        staffDao.insert(crmStaff);
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
    @Override
    public PageBean<CrmStaff> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<CrmStaff> pageBean) {
        this.pageBean = pageBean;
    }
}
