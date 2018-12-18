package com.example.hellosb.service;

import com.example.hellosb.entity.Account;

import java.util.List;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
public interface IAccountService {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
