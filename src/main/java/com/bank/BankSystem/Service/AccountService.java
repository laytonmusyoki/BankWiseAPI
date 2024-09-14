package com.bank.BankSystem.Service;

import com.bank.BankSystem.Entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AccountService {
    public Map<String,String> createAccount(Account account);
    public List<Account> getAllAccountDetails();
    public Account getBankDetailsByAccountNumber(Long accountNumber);
    public Account depositAmount(Long accountNumber,Double amount);
    public Account withdrawMoney(Long accountNumber,Double amount);

    public Map<String,String> closeAccount(Long accountNumber);
}
