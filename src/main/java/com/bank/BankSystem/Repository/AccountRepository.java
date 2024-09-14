package com.bank.BankSystem.Repository;

import com.bank.BankSystem.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
