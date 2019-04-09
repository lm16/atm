package com.controller;

import com.entity.Account;
import com.entity.Card;
import com.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.service.AccountService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private AccountService accountService;
    private CardService cardService;

    @Autowired
    public AdminController(AccountService accountService, CardService cardService){
        this.accountService = accountService;
        this.cardService = cardService;
    }

    @GetMapping("/index.do")
    public String admin(){
        return "register.html";
    }

    //账户注册生成
    @PostMapping("/account.do")
    public @ResponseBody String account(@RequestBody Account account){
        return accountService.create(account);
    }

    @PostMapping("/card.do")
    public @ResponseBody String card(@RequestBody Card card){
        return cardService.create(card);
    }

    @PostMapping("/multi.do")
    public @ResponseBody String multi(@RequestBody Card card){
        return "multi";
    }
}
