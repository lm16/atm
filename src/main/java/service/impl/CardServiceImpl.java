package service.impl;

import dao.CardDao;
import dao.impl.CardDaoImpl;
import entity.Bill;
import entity.Card;
import service.CardService;

import java.math.BigDecimal;

public class CardServiceImpl implements CardService {

    private CardDao cardDao = new CardDaoImpl();

    @Override
    public String showMoney(Card card) {
        if(cardDao.getOne(card)==null){
            return "failed";
        }else {
            return String.valueOf(cardDao.getOne(card).getBalance());
        }
    }

    @Override
    public String updateMoney(Card a, Bill to, Card b) {
        BigDecimal balanceChange; //balanceChange终
        int type = to.getType();  //交易类型

        if(type == 0) {  //存款
            balanceChange = cardDao.getOne(a).getBalance().add(to.getChange());
            a.setBalance(balanceChange);
            cardDao.update(a);
        } else if(type == 1) {   //取款
            balanceChange = cardDao.getOne(a).getBalance().subtract(to.getChange());
            a.setBalance(balanceChange);
            cardDao.update(a);
        } else if(type == 2){   //转账
            balanceChange = cardDao.getOne(a).getBalance().subtract(to.getChange());
            a.setBalance(balanceChange);
            cardDao.update(a);
            balanceChange = cardDao.getOne(b).getBalance().add(to.getChange());
            b.setBalance(balanceChange);
            cardDao.update(b);
        }
        return null;
    }
}
