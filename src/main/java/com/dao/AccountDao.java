package com.dao;

import com.entity.Account;

public interface AccountDao {

    /*
    比对，账户名、密码
     */
    Account getOne(Account account);

    /*
    多次匹配失败，禁止操作 或 清零失败次数
     */
    void updateFrozen(Account account);

    /*
    创建账户
     */
    int create(Account account);
}
