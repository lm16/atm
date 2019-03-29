package controller;

import entity.Account;
import entity.Bill;
import entity.Card;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.AccountService;
import service.CardService;
import service.impl.AccountServiceImpl;
import service.impl.CardServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"account", "card"})
public class MainController {

    private AccountService accountService = new AccountServiceImpl();
    private CardService cardService = new CardServiceImpl();

    //拦截主页
    @RequestMapping(value = "index.do", method = RequestMethod.GET)
    public String index(HttpSession httpSession){
        Account account = (Account)httpSession.getAttribute("account");
        Card card = (Card)httpSession.getAttribute("card");
        if(account==null|| card==null)
            return "login.html";
        else
            return "index.jsp";
    }

    //账户注册
    @RequestMapping(value = "/account.do", method = RequestMethod.POST)
    public @ResponseBody String account(@RequestBody Account account){
        return accountService.create(account);
    }

    //验证登录
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public @ResponseBody String login(@RequestBody Account account, ModelMap modelMap){
        String belong = accountService.getOne(account);

        if(!belong.equals("failed")){
            modelMap.addAttribute("account", account);
        }

        return belong;
    }

    //允许访问
    @RequestMapping("/jump.do")
    public String jump(HttpServletRequest request, ModelMap modelMap){
        Card card = new Card();
        card.setCardId(Long.parseLong(request.getParameter("cardId")));
        modelMap.addAttribute("card", card);

        return "index.jsp";
    }

    //显示余额
    @RequestMapping(value="show.do", method = RequestMethod.POST)
    public @ResponseBody String showMoney(@RequestBody Card card){

        return cardService.showMoney(card);
    }

    @RequestMapping(value="/update.do", method = RequestMethod.POST)
    public @ResponseBody String updateMoney(@RequestBody Param param){

        return cardService.updateMoney(param.a, param.to, param.b);
    }
}

class Param{
    public Card a;
    public Bill to;
    public Card b;
}
