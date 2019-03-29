package dao;

import entity.Account;

public interface AccountDao {

    Account getOne(Account account);

    int create(Account account);

}
