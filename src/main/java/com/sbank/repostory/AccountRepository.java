package com.sbank.repostory;

import com.sbank.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account save(Account user);

    Optional<Account> findById(Long id);
}