package com.transaction.innotest.service;

import com.transaction.innotest.model.Account;
import com.transaction.innotest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService2 {
    @Autowired
    AccountRepository accountRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transactionTest2() {
        accountRepository.save(Account.builder()
                .name("xiaozhang")
                .balance(new BigDecimal(0))
                .build());
        int[] a = new int[10];
        a[11] = 3;
    }

    @Transactional
    public void transactionTest(Account account) {
        accountRepository.save(account);
    }
}
