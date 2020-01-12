package com.sbank.sbank.repostory;

import com.sbank.sbank.model.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {

    Transfer save(Transfer client);

    Optional<Transfer> findById(Long id);
}