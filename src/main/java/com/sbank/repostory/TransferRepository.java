package com.sbank.repostory;

import com.sbank.model.Transfer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {

    Transfer save(Transfer client);

    Optional<Transfer> findById(Long id);

    List<Transfer> findAll();

    @Query("select a from #{#entityName} a where a.toAccountId = :toAccountId ")
    List<Transfer> findAllByAccountId(@Param("toAccountId") Long id);

}