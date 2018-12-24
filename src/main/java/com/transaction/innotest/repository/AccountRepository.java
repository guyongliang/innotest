package com.transaction.innotest.repository;

import com.transaction.innotest.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
