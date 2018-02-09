package com.wsh.crm.staff.dao.impl;

import com.wsh.crm.staff.dao.StaffDao;
import com.wsh.crm.staff.domain.CrmStaff;
import com.wsh.crm.staff.service.StaffService;
import com.wsh.crm.util.PageBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class StaffDaoImplTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
    }

    @Test
    public void test() throws Exception {
        StaffService staffService = (StaffService) context.getBean("staffService");
        PageBean<CrmStaff> pageBean = staffService.queryAll(1, "ee050687bd1a4455a153d7bbb7000001", "", "");
        System.out.println(pageBean);
        List<CrmStaff> list = pageBean.getList();
        for (CrmStaff staff : list) {
            System.out.println(staff);
        }
//        List<CrmStaff> crmStaffs = staffService.queryAll(1);
//        for (CrmStaff crmStaff : crmStaffs) {
//            System.out.println(crmStaff);
//        }
//        System.out.println(staffService.getPageBean());
    }
}