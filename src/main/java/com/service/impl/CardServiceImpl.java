package com.service.impl;

import com.dao.CardDao;
import com.dao.impl.CardDaoImpl;
import com.entity.Card;
import com.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private CardDao cardDao;

    @Autowired
    public CardServiceImpl(CardDao cardDao){
        this.cardDao = cardDao;
    }

    @Override
    public String getBalance(Card card) {

        Card one = cardDao.getOne(card);

        if(one==null){
            return "failed";
        }else {
            return String.valueOf(one.getBalance());
        }
    }

    @Override
    public String create(Card card) {
        if(cardDao.create(card)==0){
            return "failed";
        }else{
            return "success";
        }
    }
}
