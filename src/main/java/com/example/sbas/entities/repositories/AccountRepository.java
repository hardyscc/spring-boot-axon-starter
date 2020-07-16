package com.example.sbas.entities.repositories;

import com.example.sbas.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
