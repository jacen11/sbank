package com.sbank.repostory;

import com.sbank.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Iterable<Account> findAll();

    Iterable<Account>  findAllByUserId(Long userId);

    Account save(Account user);

    Optional<Account> findById(Long id);

    Optional<Account>  findByIdAndUserId( Long id,  Long userId);

}
