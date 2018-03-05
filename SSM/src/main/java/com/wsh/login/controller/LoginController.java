package com.wsh.login.controller;

import com.wsh.admin.domain.AdminInfo;
import com.wsh.admin.service.AdminService;
import com.wsh.role.domain.ModuleInfo;
import com.wsh.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController{

    private final static int SUCCESS = 0;

    private final static int ADMIN_CODE_ERROR = 1;

    private final static int PASSWORD_ERROR = 2;

    private final static int IMAGE_CODE_ERROR = 3;

    @Resource
    private AdminService adminService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "main/login";
    }
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "main/index";
    }
    @RequestMapping("/nopower")
    public String nopower(){
        return "main/nopower";
    }
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(String adminCode, String password, String code, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        String imageCode = (String) session.getAttribute("imageCode");
        if (code == null || !code.equalsIgnoreCase(imageCode)){
            map.put("flag",IMAGE_CODE_ERROR);
            return map;
        }
        AdminInfo adminInfo = adminService.queryByCode(adminCode);
        if (adminCode == null){
            map.put("flag",ADMIN_CODE_ERROR);
            return map;
        }else if (!adminInfo.getPassword().equals(password)){
            map.put("flag",PASSWORD_ERROR);
            return map;
        }else {
            session.setAttribute("admin",adminInfo);
            List<ModuleInfo> moduleInfos = adminService.queryModulesByAdmin(adminInfo.getAdminId());
            session.setAttribute("allModules",moduleInfos);
            map.put("flag",SUCCESS);
            return map;
        }
    }
    @RequestMapping("/createImage")
    public void createImage(HttpServletResponse response, HttpSession session)throws Exception{
        Map<String,BufferedImage> imageMap = ImageUtil.createImage();
        String code = imageMap.keySet().iterator().next();
        session.setAttribute("imageCode",code);
        BufferedImage image = imageMap.get(code);
        response.setContentType("image/jpeg");
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image,"jpeg",outputStream);
        outputStream.close();

    }
}
