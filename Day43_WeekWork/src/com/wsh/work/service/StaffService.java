package com.wsh.work.service;

import com.wsh.work.bean.Staff;
import com.wsh.work.dao.StaffDao;

import java.util.List;

public class StaffService {
    private StaffDao sd = new StaffDao();

    public List<Staff> queryAll(){
        return sd.queryAll();
    }

    public void update(Staff staff){
        sd.update(staff);
    }

    public void save(Staff staff){
        sd.add(staff);
    }
}
