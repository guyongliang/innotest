package com.transaction.innotest.controller;

import com.transaction.innotest.RequestVO.AccountVO;
import com.transaction.innotest.model.Account;
import com.transaction.innotest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/add")
    public Account add() {
        Account account = Account.builder()
                .name("xiaoming")
                .balance(new BigDecimal(0))
                .build();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            System.out.println("等待10000毫秒");
//            e.printStackTrace();
//        }
        System.out.println(account.toString());
        return accountService.add(account);
    }

    @GetMapping("/findOne")
    public Account findOne(Long id) {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            System.out.println("等待10000毫秒");
//            e.printStackTrace();
//        }

        return accountService.findOne(id);
    }

    @GetMapping("/findByName")
    public List<Account> findByName(String name) {

        List<Account> list = accountService.findByName(name);

//        System.out.println(list.size());
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            System.out.println("等待10000毫秒");
//            e.printStackTrace();
//        }
        return list;
    }

    @GetMapping("/transactionTest")
    public String transactionTest() {
        Account account = Account.builder()
                .name("xiaoming")
                .balance(new BigDecimal(0))
                .build();
        accountService.transactionTest(account);
        return "success";
    }
}
