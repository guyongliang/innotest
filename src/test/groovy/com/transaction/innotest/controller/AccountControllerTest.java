package com.transaction.innotest.controller;

import com.transaction.innotest.InnotestApplicationTests;
import com.transaction.innotest.controller.AccountController;
import com.transaction.innotest.model.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountControllerTest extends InnotestApplicationTests {

    @Autowired
    AccountController accountController;

    @Test
    public void test(){
        Account account = accountController.findOne(1L);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account);
//        new Thread(() -> accountController.findOne(1L));
    }

    @Test
    public void findByNameTest(){
        List<Account> accounts = accountController.findByName("xiaoming");
        System.out.println(accounts.size());
//        System.out.println("查询1完毕，等待五秒");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("等待完成");
//
//        List<Account> accountList = accountController.findByName("xiaoming");
//        System.out.println(accountList.size());
//        System.out.println("查询2完毕，等待五秒");


//        Thread t = Thread.currentThread();
//  new Thread(() -> accountController.findByName("xiaoming"));
    }

    @Test
    public void transactionTest() {
        accountController.transactionTest();
    }
}