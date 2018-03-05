package com.wsh.service.controller;

import com.wsh.cost.domain.Cost;
import com.wsh.service.domain.Service;
import com.wsh.service.service.ServiceService;
import com.wsh.service.service.util.ServicePageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Resource
    private ServiceService serviceService;

    @RequestMapping("/service_list")
    public String service_list(ServicePageBean pageBean, Model model){
        pageBean = serviceService.queryAllByPage(pageBean);
        model.addAttribute("pageBean",pageBean);
        return "service/service_list";
    }
    @RequestMapping("/startService")
    @ResponseBody
    public Map<String,Object> startService(int service_id){
        return serviceService.updateServiceStart(service_id);
    }
    @RequestMapping("/pauseService")
    @ResponseBody
    public Map<String,Object> pauseService(int service_id){
        return serviceService.updateServicePause(service_id);
    }
    @RequestMapping("/toAddService")
    public String toAddService(Model model){
        List<Cost> costs = serviceService.queryAllCost();
        model.addAttribute("costs",costs);
        return "service/service_add";
    }
    @RequestMapping("/findAccount")
    @ResponseBody
    public Map<String,Object> findAccount(String idcardNo){
        return serviceService.queryAccountByIdcardNo(idcardNo);
    }
    @RequestMapping("/service_add")
    public String service_add(Service service){
        serviceService.addService(service);
        return "redirect:service_list";
    }
    @RequestMapping("/toModi")
    public String toModi(Integer service_id,Model model){
        Service service = serviceService.queryByServiceId(service_id);
        List<Cost> costs = serviceService.queryAllCost();
        model.addAttribute("costs",costs);
        model.addAttribute("service",service);
        return "service/service_modi";
    }
    @RequestMapping("/service_modi")
    public String service_modi(Service service){
        serviceService.updateService(service);
        return "redirect:service_list";
    }
    @RequestMapping("/service_detail")
    public String service_detail(Integer service_id,Model model){
        Service service = serviceService.queryByServiceId(service_id);
        model.addAttribute("service",service);
        return "service/service_detail";
    }
    @RequestMapping("/service_delete")
    public String service_delete(Integer service_id){
        serviceService.deleteService(service_id);
        return "redirect:service_list";
    }
}
