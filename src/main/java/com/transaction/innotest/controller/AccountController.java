package com.transaction.innotest.controller;

import com.transaction.innotest.RequestVO.AccountVO;
import com.transaction.innotest.model.Account;
import com.transaction.innotest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/add")
    public Account add(@RequestBody AccountVO accountVO) {
        Account account = Account.builder()
                .name(accountVO.getName())
                .balance(accountVO.getBalance())
                .build();
        System.out.println(account.toString());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("等待10000毫秒");
            e.printStackTrace();
        }
        return accountService.add(account);
    }
}
