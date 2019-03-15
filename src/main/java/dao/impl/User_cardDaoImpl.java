package dao.impl;

import bean.User_card;
import dao.User_cardDao;
import dao.dbutils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class User_cardDaoImpl implements User_cardDao {

    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    public String validate(User_card user_card) {
        User_card real = null;
        String sql = "select * from user_card where BankCard=?";

        System.out.println(user_card.getBankCard());

        try{
            real = qr.query(sql, new BeanHandler<>(User_card.class), user_card.getBankCard());
        }catch (Exception e){
            e.printStackTrace();
        }

        if(real == null){
            return "failed";
        } else{
            return "success";
        }
    }
}






