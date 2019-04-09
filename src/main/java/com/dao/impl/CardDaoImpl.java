package com.dao.impl;

import com.dao.CardDao;
import com.dao.config.C3P0;

import com.entity.Card;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardDaoImpl implements CardDao {

    private QueryRunner qr = new QueryRunner(C3P0.getDataSource());

    @Override
    public List getCardIdList(Long belong) {
        String sql = "select cardId from card where belong=?";

        List cardIdList = new ArrayList<>();
        try{
            cardIdList = qr.query(sql, new ColumnListHandler<>(), belong);
        }catch (Exception e){
            e.printStackTrace();
        }

        return cardIdList;
    }

    @Override
    public void updateBalance(Card card) {
        String sql = "update card set balance=? where cardId=?";

        try{
            qr.update(sql, card.getBalance(), card.getCardId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Card getOne(Card card) {
        return getOne(card.getCardId());
    }
    @Override
    public Card getOne(String cardId) {
        String sql = "select * from card where cardId = ?";
        Card one = null;
        try{
            one = qr.query(sql, new BeanHandler<>(Card.class), cardId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return one;
    }

    @Override
    public int create(Card card) {
        String sql = "insert into card(cardId, balance, pin, belong) values(?, ?, ?, ?)";

        int row = 0;
        try{
            row = qr.update(sql, card.getCardId(), card.getBalance(), card.getPin(), card.getBelong());
        }catch (Exception e){
            e.printStackTrace();
        }

        return row;
    }
}
