package com.wsh.admin.service;

import com.wsh.admin.domain.AdminInfo;
import com.wsh.admin.service.util.AdminPageBean;
import com.wsh.role.domain.ModuleInfo;

import java.util.List;
import java.util.Map;

public interface AdminService {


    AdminPageBean queryAllByPage(AdminPageBean pageBean);

    Map<String ,Object> updatePassword(Integer[] admin_ids);

    void insertAdmin(AdminInfo adminInfo);

    AdminInfo queryByAdminId(Integer admin_id);

    void updateAdmin(AdminInfo adminInfo);

    void deleteAdmin(Integer admin_id);

    AdminInfo queryByCode(String adminCode);

    List<ModuleInfo> queryModulesByAdmin(Integer adminId);
}
