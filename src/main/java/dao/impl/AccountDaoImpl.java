package dao.impl;

import dao.AccountDao;
import dao.config.C3P0;
import entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class AccountDaoImpl implements AccountDao {

    private QueryRunner qr = new QueryRunner(C3P0.getDataSource());

    @Override
    public Account getOne(Account account) {
        String sql = "select * from account where phone=? and passwd=?";

        Account one = null;
        try{
            one = qr.query(sql, new BeanHandler<>(Account.class), account.getPhone(), account.getPasswd());
        }catch (Exception e){
            e.printStackTrace();
        }

        return one;
    }

    @Override
    public int create(Account account) {
        String sql = "insert into account values(?, ?)";

        int row = 0;
        try{
            row = qr.update(sql, account.getPhone(), account.getPasswd());
        }catch (Exception e){
            e.printStackTrace();
        }

        return row;
    }
}
