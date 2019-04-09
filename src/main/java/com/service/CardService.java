package com.service;

import com.entity.Card;

public interface CardService {


    /*
    卡内余额
     */
    String getBalance(Card card);

    /*
    创建卡号
     */
    String create(Card card);
}
