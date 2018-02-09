package com.wsh.cost.controller;

import com.wsh.cost.domain.Cost;
import com.wsh.cost.service.CostService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Scope("prototype")
@RequestMapping("/cost")
public class CostController {

    @Resource
    private CostService costService;

    @RequestMapping("/cost_list")
    public String fee_list(Model model){
        List<Cost> costList = costService.queryAll();
        model.addAttribute("costList",costList);
        return "/fee/cost_list";
    }


}
