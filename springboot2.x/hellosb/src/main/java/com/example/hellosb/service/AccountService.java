package com.example.hellosb.service;

import com.example.hellosb.dao.AccountMapper;
import com.example.hellosb.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }
    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }
    public int delete(int id) {
        return accountMapper.delete(id);
    }
    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }
    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }

    @Transactional
    public void transfer() throws RuntimeException{
        accountMapper.update2(90,1);
//        int i=1/0;
        accountMapper.update2(110,2);
    }
}
