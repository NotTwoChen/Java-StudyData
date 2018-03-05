package com.wsh.admin.controller;

import com.wsh.admin.domain.AdminInfo;
import com.wsh.admin.service.AdminService;
import com.wsh.admin.service.util.AdminPageBean;
import com.wsh.role.domain.ModuleInfo;
import com.wsh.role.domain.RoleInfo;
import com.wsh.role.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;
    @Resource
    private RoleService roleService;

    @RequestMapping("/admin_list")
    public String admin_list(AdminPageBean pageBean, Model model){
        pageBean = adminService.queryAllByPage(pageBean);
        model.addAttribute("pageBean",pageBean);
        List<ModuleInfo> moduleInfos = roleService.queryAllModule();
        model.addAttribute("moduleInfos",moduleInfos);
        return "admin/admin_list";
    }
    @RequestMapping("/resetPassword")
    @ResponseBody
    public Map<String,Object> resetPassword(Integer[] admin_ids){
        return adminService.updatePassword(admin_ids);
    }
    @RequestMapping("/toAddAdmin")
    public String  toAddAdmin(Model model){
        List<RoleInfo> roleInfos = roleService.queryAllRole();
        model.addAttribute("roleInfos",roleInfos);
        return "admin/admin_add";
    }
    @RequestMapping("/admin_add")
    public String admin_add(AdminInfo adminInfo){
        adminService.insertAdmin(adminInfo);
        return "redirect:admin_list";
    }
    @RequestMapping("/toModiAdmin")
    public String toModiAdmin(Integer admin_id ,Model model){
        AdminInfo adminInfo = adminService.queryByAdminId(admin_id);
        model.addAttribute("adminInfo",adminInfo);
        List<RoleInfo> roleInfos = roleService.queryAllRole();
        model.addAttribute("roleInfos",roleInfos);
        return "admin/admin_modi";
    }
    @RequestMapping("/admin_modi")
    public String admin_modi(AdminInfo adminInfo){
        adminService.updateAdmin(adminInfo);
        return "redirect:admin_list";
    }
    @RequestMapping("/admin_delete")
    public String admin_delete(Integer admin_id){
        adminService.deleteAdmin(admin_id);
        return "redirect:admin_list";
    }
}
