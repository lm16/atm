package com.service;

import com.entity.Account;

public interface AccountService {

    /*
    __登录验证__
     */
    String login(Account account);

    /*
    创建账户
     */
    String create(Account account);
}
