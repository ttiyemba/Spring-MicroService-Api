package com.qa.tapiwa.spring.data.repo;

import com.qa.tapiwa.spring.data.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>{
}
