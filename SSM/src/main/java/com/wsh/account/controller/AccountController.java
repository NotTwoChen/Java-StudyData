package com.wsh.account.controller;

import com.wsh.account.domain.Account;
import com.wsh.account.service.AccountService;
import com.wsh.account.service.util.AccountPageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/account_list")
    public String account_list(String nowPageIndex,String idcardNo,String realName,String loginName,String status, Model model){
        nowPageIndex = nowPageIndex == null ? "1" : nowPageIndex;
        AccountPageBean pageBean = accountService.queryAllByPage(Integer.parseInt(nowPageIndex),idcardNo,realName,loginName,status);
        model.addAttribute("pageBean",pageBean);
        return "account/account_list";
    }
    @RequestMapping("/startAccount")
    public String startAccount(int account_id){
        Account account = new Account(account_id, "1");
        accountService.updateStatus(account);
        return "redirect:account_list";
    }
    @RequestMapping("/pauseAccount")
    public String pauseAccount(int account_id){
        Account account = new Account(account_id, "2");
        accountService.updateStatus(account);
        return "redirect:account_list";
    }
    @RequestMapping("/deleteAccount")
    public String deleteAccount(int account_id){
        Account account = new Account(account_id, "3");
        accountService.updateStatus(account);
        return "redirect:account_list";
    }
    @RequestMapping("/toAddAccount")
    public String addAccount(){
        return "account/account_add";
    }
    @RequestMapping("/account_add")
    public String account_add(Account account){
        accountService.addAccount(account);
        return "redirect:account_list";
    }
    @RequestMapping("/account_detail")
    public String account_detail(int account_id,Model model){
        Account account = accountService.queryByAccountId(account_id);
        model.addAttribute("account",account);
        return "account/account_detail";
    }
    @RequestMapping("/toModiAccount")
    public String modiAccount(int account_id,Model model){
        Account account = accountService.queryByAccountId(account_id);
        model.addAttribute("account",account);
        return "account/account_modi";
    }
    @RequestMapping("/account_modi")
    public String account_modi(Account account){
        accountService.updateAccount(account);
        return "redirect:account_list";
    }
}
