package com.transaction.innotest.repository;

import com.transaction.innotest.model.Account;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Override
    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Account save(Account account);

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Account> findById(Long id);

//    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Account> findByName(String name);
}
