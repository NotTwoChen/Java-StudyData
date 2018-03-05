package com.wsh.role.controller;

import com.wsh.role.domain.ModuleInfo;
import com.wsh.role.domain.RoleInfo;
import com.wsh.role.domain.RoleModule;
import com.wsh.role.service.RoleService;
import com.wsh.role.service.util.RolePageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("role_list")
    public String role_list(RolePageBean pageBean,Model model){
        pageBean = roleService.queryAllByPage(pageBean);
        model.addAttribute("pageBean",pageBean);
        return "role/role_list";
    }
    @RequestMapping("/toUpdateRole")
    public String toUpdateRole(int role_id,Model model){
        List<ModuleInfo> moduleInfos = roleService.queryAllModule();
        model.addAttribute("moduleInfos",moduleInfos);
        RoleInfo roleInfo = roleService.queryByRoleId(role_id);
        model.addAttribute("role",roleInfo);
        return "role/role_modi";
    }
    @RequestMapping("/role_update")
    public String role_update(RoleInfo roleInfo){
        roleService.updateRole(roleInfo);
        return "redirect:role_list";
    }
    @RequestMapping("/toAddRole")
    public String toAddRole(Model model){
        List<ModuleInfo> moduleInfos = roleService.queryAllModule();
        model.addAttribute("moduleInfos",moduleInfos);
        return "role/role_add";
    }
    @RequestMapping("/role_add")
    public String role_add(RoleInfo roleInfo){
        roleService.insertRole(roleInfo);
        return "redirect:role_list";
    }
    @RequestMapping("/role_delete")
    public String role_delete(int role_id){
        roleService.deleteRole(role_id);
        return "redirect:role_list";
    }
}
