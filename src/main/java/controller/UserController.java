package controller;

import bean.User_info;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.User_infoService;
import service.impl.User_infoServiceImpl;

@Controller
public class UserController {

    User_infoService user_infoService = new User_infoServiceImpl();

    @RequestMapping(value="/user-list.do", produces = "application/json; charset=utf-8")
    public @ResponseBody String UserList() throws JsonProcessingException{

        return user_infoService.getList();
    }


}
