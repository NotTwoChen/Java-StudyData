package com.wsh.cost.controller;

import com.wsh.cost.domain.Cost;
import com.wsh.cost.service.CostService;
import com.wsh.cost.service.util.CostPageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Controller
@RequestMapping("/cost")
public class CostController {

    @Resource
    private CostService costService;

    @RequestMapping("/cost_list")
    public String cost_list(Model model, String nowPageIndex,String sort,String value){
        nowPageIndex = nowPageIndex == null? "1" : nowPageIndex;
        if (sort == null && value == null){ sort = "asc";value = "id"; }
        CostPageBean pageBean = costService.queryAll(Integer.parseInt(nowPageIndex), sort, value);
        pageBean.setSort(sort);
        pageBean.setValue(value);
        model.addAttribute("pageBean",pageBean);
        return "cost/cost_list";
    }
    @RequestMapping("/toAddCost")
    public String toAdd(){
        return "cost/cost_add";
    }
    @RequestMapping("/addCost")
    public String cost_add(Cost cost){
        cost.setStatus("1");
        cost.setCreatime(new Timestamp(System.currentTimeMillis()));
        costService.addCost(cost);
        return "redirect:cost_list";
    }
    @RequestMapping("/toUpdateCost")
    public String toUpdate(int id,Model model){
        Cost cost = costService.queryById(id);
        model.addAttribute("cost",cost);
        return "cost/cost_modi";
    }
    @RequestMapping("/updateCost")
    public String cost_update(Cost cost){
        costService.updateById(cost);
        return "redirect:cost_list";
    }
    @RequestMapping("/deleteCost")
    public String cost_delete(int id){
        costService.deleteCost(id);
        return "redirect:cost_list";
    }
    @RequestMapping("/cost_sort")
    public String cost_sort(String sort,String value){
        System.out.println(sort);
        System.out.println(value);
        return "cost/cost_list";
    }
    @RequestMapping("/cost_detail")
    public String cost_detail(int id,Model model){
        Cost cost = costService.queryById(id);
        model.addAttribute("cost",cost);
        return "cost/cost_detail";
    }


}
