package com.sbank.repostory;

import com.sbank.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<User, Long> {

    User save(User user);

    Optional<User> findById(Long id);
}