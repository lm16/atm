package com.dao.impl;

import com.dao.BillDao;
import com.dao.config.C3P0;
import com.entity.Bill;
import org.apache.commons.dbutils.ColumnHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Repository
public class BillDaoImpl implements BillDao {

    private QueryRunner qr = new QueryRunner(C3P0.getDataSource());

    @Override
    public void create(Bill bill) {
        if(bill.getSelfId()==0) {
            String sql = "insert into bill (time, cardId, type, changee, balanceChange) values (?, ?, ?, ?, ?)";

            try {
                qr.insert(sql, new BeanHandler<>(Bill.class), bill.getTime(), bill.getCardId(), bill.getType(), bill.getChangee(), bill.getBalanceChange());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            String sql = "insert into bill (time, cardId, type, changee, balanceChange, selfId) values (?, ?, ?, ?, ?, ?)";

            try {
                qr.insert(sql, new BeanHandler<>(Bill.class), bill.getTime(), bill.getCardId(), bill.getType(), bill.getChangee(), bill.getBalanceChange(), bill.getSelfId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Bill getBy(Bill bill) {
        String sql = "select * from bill where time=? and cardId=?";

        Bill one = null;
        try{
            one = qr.query(sql, new BeanHandler<>(Bill.class), bill.getTime(), bill.getCardId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return one;
    }

    @Override
    public List<Bill> getList(String cardId) {
        String sql = "select DATE_FORMAT(time, '%Y-%m-%d %H:%i:%s') time, type, changee, balanceChange from bill where cardId = ?";

        List<Bill> list = null;
        try{
            list = qr.query(sql, new BeanListHandler<>(Bill.class), cardId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
