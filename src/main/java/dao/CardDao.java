package dao;

import entity.Account;
import entity.Card;

import java.math.BigDecimal;
import java.util.List;

public interface CardDao {

    List<Long> getField(Account account);
    Card getOne(Card card);
    void update(Card card);
}
