package com.transaction.innotest.service;

import com.transaction.innotest.model.Account;
import com.transaction.innotest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public Account add(Account account) {
        return accountRepository.save(account);
    }
}
