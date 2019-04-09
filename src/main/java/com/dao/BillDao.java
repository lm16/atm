package com.dao;

import com.entity.Bill;

import java.util.List;

public interface BillDao {

    /*
    创建一条记录
     */
    void create(Bill bill);

    /*
    __卡号转出记录得到对方的转入记录__
     */
    Bill getBy(Bill bill);

    /*
    符合卡号的记录
     */
    List<Bill> getList(String cardId);
}
