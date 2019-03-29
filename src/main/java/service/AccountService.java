package service;

import entity.Account;

public interface AccountService {
    String create(Account account);
    String getOne(Account account);
}
