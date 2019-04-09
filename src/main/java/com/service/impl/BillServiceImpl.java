package com.service.impl;

import com.dao.BillDao;
import com.dao.CardDao;
import com.entity.Bill;
import com.entity.Card;
import com.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private CardDao cardDao;

    private BillDao billDao;

    @Autowired
    public BillServiceImpl(CardDao cardDao, BillDao billDao){
        this.cardDao = cardDao;
        this.billDao = billDao;
    }

    @Override
    public String updateMoney(Bill bill) {

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date date= new Date();

        Card card = cardDao.getOne(bill.getCardId());
        BigDecimal balanceChange; //交易后余额

        byte type = bill.getType();  //交易类型
        if(type == 0) {  //存款
            balanceChange = card.getBalance().add(bill.getChangee());
            if(balanceChange.compareTo(new BigDecimal(999999))>0){
                return "failed";
            }
            card.setBalance(balanceChange);
            cardDao.updateBalance(card);

            bill.setTime(sdf.format(date));
            bill.setBalanceChange(balanceChange);
            billDao.create(bill);
            return String.valueOf(balanceChange);
        } else if(type == 1) {   //取款
            balanceChange = card.getBalance().subtract(bill.getChangee());
            if(balanceChange.compareTo(new BigDecimal(0))<0){
                return "failed";
            }
            card.setBalance(balanceChange);
            cardDao.updateBalance(card);

            bill.setTime(sdf.format(date));
            bill.setBalanceChange(balanceChange);
            billDao.create(bill);
            return String.valueOf(balanceChange);
        }else{
            return "彩蛋？？";
        }
    }

    @Override
    public String turnMoney(Bill a, Bill b) {

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date date= new Date();

        Card aCard = cardDao.getOne(a.getCardId());
        Card bCard = cardDao.getOne(b.getCardId());
        if(bCard == null){
            return "检查下对方卡号？";
        }
        BigDecimal aBalance;
        BigDecimal bBalance;

        aBalance = aCard.getBalance().subtract(a.getChangee());
        if(aBalance.compareTo(new BigDecimal(0))<0){
            return "failed";
        }
        bBalance = bCard.getBalance().add(b.getChangee());
        if(aBalance.compareTo(new BigDecimal(999999))>0){
            return "failed";
        }
        aCard.setBalance(aBalance);
        bCard.setBalance(bBalance);
        cardDao.updateBalance(aCard);
        cardDao.updateBalance(bCard);

        a.setTime(sdf.format(date));
        b.setTime(sdf.format(date));
        a.setBalanceChange(aBalance);
        b.setBalanceChange(bBalance);
        billDao.create(a);

        b.setSelfId(billDao.getBy(a).getBillId());
        billDao.create(b);

        return String.valueOf(aBalance);
    }

    @Override
    public List<Bill> getList(String cardId) {
        return billDao.getList(cardId);
    }
}
