package com.dao;

import com.entity.Card;

import java.util.List;

public interface CardDao {

    /*
    提供卡号选择: Account
     */
    List getCardIdList(Long belong);

    /*
    更新了余额: Bill
     */
    void updateBalance(Card card);

    /*
    取卡
     */
    Card getOne(Card card);
    Card getOne(String cardId);

    /*
    创建卡号
     */
    int create(Card card);
}
