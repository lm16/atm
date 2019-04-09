package com.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.dao.AccountDao;
import com.dao.CardDao;
import com.entity.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    private CardDao cardDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao, CardDao cardDao){
        this.accountDao = accountDao;
        this.cardDao = cardDao;
    }

    @Override
    public String login(Account account) {

        Account one = accountDao.getOne(account);

        /*
        处理账户名
         */
        if(one == null){
            return "1";
        }else {
            /*
            处理锁定
             */
            if(one.getFrozen()==3){
                return "3";
            } else{
                /*
                处理密码
                 */
                if(!one.getPasswd().equals(account.getPasswd())) {
                    one.setFrozen((byte)(one.getFrozen()+1));
                    accountDao.updateFrozen(one);
                    return "2";
                }else{
                    one.setFrozen((byte) 0);
                    accountDao.updateFrozen(one);
                    /*
                    账户匹配的卡号集
                     */
                    List cardIdList = cardDao.getCardIdList(one.getPhone());
                    ObjectMapper mapper = new ObjectMapper();

                    String json = null;
                    try {
                        json = mapper.writeValueAsString(cardIdList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return json;
                }
            }
        }
    }

    public String create(Account account){
        if(accountDao.create(account)==0){
            return "failed";
        }else{
            return "success";
        }
    }

}
