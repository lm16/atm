package com.dao.impl;

import com.dao.AccountDao;
import com.dao.config.C3P0;
import com.entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    private QueryRunner qr = new QueryRunner(C3P0.getDataSource());

    @Override
    public Account getOne(Account account) {
        String sql = "select * from account where phone=?";

        Account one = null;
        try{
            one = qr.query(sql, new BeanHandler<>(Account.class), account.getPhone());
        }catch (Exception e){
            e.printStackTrace();
        }
        return one;
    }

    public void updateFrozen(Account account) {
        String sql = "update account set frozen=? where phone=?";

        try {
            qr.update(sql, account.getFrozen(), account.getPhone());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int create(Account account) {
        String sql = "insert into account(phone, passwd, name, identity) values(?, ?, ?, ?)";

        int row = 0;
        try{
            row = qr.update(sql, account.getPhone(), account.getPasswd(), account.getName(), account.getIdentity());
        }catch (Exception e){
            e.printStackTrace();
        }

        return row;
    }
}
