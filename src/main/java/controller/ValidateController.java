package controller;

import bean.User_card;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.User_cardService;
import service.impl.User_cardServiceImpl;

@Controller
public class ValidateController {
    private User_cardService user_cardService = new User_cardServiceImpl();

    @RequestMapping(value="/validate.do", method = RequestMethod.POST)
    public @ResponseBody String validate(@RequestBody User_card user_card){
        System.out.println(user_card.getBankCard());
        return user_cardService.validate(user_card);
    }
}
