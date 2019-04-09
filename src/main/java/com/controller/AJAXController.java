package com.controller;

import com.entity.Account;
import com.entity.Bill;
import com.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.service.AccountService;
import com.service.BillService;
import com.service.CardService;

@Controller
@SessionAttributes("account")
public class AJAXController {

    private AccountService accountService;
    private CardService cardService;
    private BillService billService;

    @Autowired
    public AJAXController(AccountService accountService, CardService cardService, BillService billService){
        this.accountService = accountService;
        this.cardService = cardService;
        this.billService = billService;
    }

    //登录
    @PostMapping("/login.do")
    public @ResponseBody String login(@RequestBody Account account, ModelMap modelMap){
        String belong = accountService.login(account);

        if(!belong.equals("failed")){
            modelMap.addAttribute("account", account);
        }

        return belong;
    }

    //余额
    @PostMapping("/show.do")
    public @ResponseBody String showMoney(@RequestBody Card card){
        return cardService.getBalance(card);
    }

    /*
    存、取款
     */
    @PostMapping("/update.do")
    public @ResponseBody String updateMoney(@RequestBody Bill bill){
        return billService.updateMoney(bill);
    }

    /*
    转账
     */
    @PostMapping("/turn.do")
    public @ResponseBody String turnMoney(@RequestBody Param param){
        return billService.turnMoney(param.a, param.b);
    }
}

class Param{
    public Bill a, b;
}
