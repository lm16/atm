package com.service;

import com.entity.Bill;

import java.util.List;

public interface BillService {

    /*
    存、取款
     */
    String updateMoney(Bill bill);

    /*
    __转账__
     */
    String turnMoney(Bill a, Bill b);

    /*
    交易记录
     */
    List<Bill> getList(String cardId);
}
