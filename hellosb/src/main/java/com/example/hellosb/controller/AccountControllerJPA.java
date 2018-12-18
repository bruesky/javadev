package com.example.hellosb.controller;

import com.example.hellosb.dao.PersonDao;
import com.example.hellosb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
@RestController
@RequestMapping("/accountjpa")
public class AccountControllerJPA {

    @Autowired
    PersonDao accountDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Person> getAccounts() {
        return accountDao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getAccountById(@PathVariable("id") int id) {
        return accountDao.findById(id).orElse(null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        Person account = new Person();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        Person account1 = accountDao.saveAndFlush(account);

        return account1.toString();

    }

    @RequestMapping(method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        Person account = new Person();
        account.setMoney(money);
        account.setName(name);
        Person account1 = accountDao.save(account);
        return account1.toString();

    }
}
