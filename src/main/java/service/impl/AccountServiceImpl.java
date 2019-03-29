package service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AccountDao;
import dao.CardDao;
import dao.impl.AccountDaoImpl;
import dao.impl.CardDaoImpl;
import entity.Account;
import service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();
    private CardDao cardDao = new CardDaoImpl();

    public String create(Account account){
        if(accountDao.create(account)==0){
            return "failed";
        }else{
            return "success";
        }
    }

    @Override
    public String getOne(Account account) {

        Account one = accountDao.getOne(account);

        if(one != null){
            List<Long> field = cardDao.getField(one);
            ObjectMapper mapper = new ObjectMapper();

            String json = null;
            try{
                json = mapper.writeValueAsString(field);
            }catch (Exception e){
                e.printStackTrace();
            }

            return json;
        }else{
            return "failed";
        }
    }
}
