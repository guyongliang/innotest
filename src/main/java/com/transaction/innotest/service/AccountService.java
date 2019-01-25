package com.transaction.innotest.service;

import com.transaction.innotest.model.Account;
import com.transaction.innotest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public Account add(Account account) {
        return accountRepository.save(account);
    }

    @Transactional
    public Account findOne(Long id) {
        return accountRepository.findById(id).get();
    }

//    @Transactional(timeout = 3, isolation = Isolation.READ_COMMITTED)
    public List<Account> findByName(String name) {
        return accountRepository.findByName(name);
    }

}
