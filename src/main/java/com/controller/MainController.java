package com.controller;

import com.entity.Account;
import com.entity.Bill;
import com.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.service.BillService;
import com.service.impl.BillServiceImpl;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("card")
public class MainController {

    private BillService billService;

    @Autowired
    public MainController(BillService billService){
        this.billService = billService;
    }

    /*
    主页
     */
    @GetMapping("/index.do")
    public String index(HttpSession httpSession){
        Account account = (Account)httpSession.getAttribute("account");
        Card card = (Card)httpSession.getAttribute("card");
        if(account==null|| card==null)
            return "login.html";
        else
            return "index.jsp";
    }

    /*
    交易记录
     */
    @GetMapping("/bill.do")
    public String bill(HttpSession httpSession, Model model){

        Card card = (Card)httpSession.getAttribute("card");
        if(card == null) {
            return "login.html";
        }else{
            model.addAttribute("list", billService.getList(card.getCardId()));
            return "bill.jsp";
        }
    }

    /*
     卡号
     */
    @PostMapping("/jump.do")
    public String jump(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        Card card = new Card();
        card.setCardId(request.getParameter("cardId"));
        modelMap.addAttribute("card", card);


        return "redirect:/index.do";
    }

    @RequestMapping("/logout.do")
    public String logout(SessionStatus status, HttpSession session){
        session.removeAttribute("card");
        session.removeAttribute("account");
        status.setComplete();
        return "redirect:/index.do";
    }
}