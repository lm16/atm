package service.impl;

import bean.User_card;
import dao.User_cardDao;
import dao.impl.User_cardDaoImpl;
import service.User_cardService;

public class User_cardServiceImpl implements User_cardService {
    private User_cardDao user_cardDao = new User_cardDaoImpl();


    @Override
    public String validate(User_card user_card) {
        return user_cardDao.validate(user_card);
    }

}
