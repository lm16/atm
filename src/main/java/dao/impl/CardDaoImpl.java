package dao.impl;

import dao.CardDao;
import dao.config.C3P0;
import entity.Account;
import entity.Card;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl implements CardDao {

    private QueryRunner qr = new QueryRunner(C3P0.getDataSource());

    @Override
    public List<Long> getField(Account account) {
        String sql = "select cardId from card where belong=?";

        List<Long> field = new ArrayList<>();
        try{
            field = qr.query(sql, new ColumnListHandler<>(), account.getPhone());
        }catch (Exception e){
            e.printStackTrace();
        }

        return field;
    }

    @Override
    public Card getOne(Card card) {
        System.out.println(card.getCardId()+"  aa");
        String sql = "select * from card where cardId = ?";
        Card one = new Card();

        try{
            one = qr.query(sql, new BeanHandler<>(Card.class), card.getCardId());
        }catch (Exception e){
            e.printStackTrace();
        }

        return one;
    }

    @Override
    public void update(Card card) {
        String sql = "update card set balance=? where cardId=?";
        try{
            qr.update(sql, card.getBalance(), card.getCardId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
