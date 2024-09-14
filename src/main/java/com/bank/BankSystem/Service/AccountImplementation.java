package com.bank.BankSystem.Service;

import com.bank.BankSystem.Entity.Account;
import com.bank.BankSystem.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountImplementation implements AccountService {

    @Autowired
    AccountRepository repo;

    @Override
    public Map<String,String> createAccount(Account account) {
        repo.save(account);
        Map<String,String> response=new HashMap<>();
        response.put("message","Account Created Successfully");
        return response;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> account=repo.findAll();
        return account;
    }

    @Override
    public Account getBankDetailsByAccountNumber(Long accountNumber) {
        Optional<Account> account=repo.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("No account with that accountNumber");
        }
        Account foundAccount=account.get();
        return foundAccount;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        Optional<Account> account=repo.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("No account with that accountNumber");
        }
        Account foundAccount=account.get();
        Double totalAmount= foundAccount.getAccountBalance() + amount;
        foundAccount.setAccountBalance(totalAmount);
        repo.save(foundAccount);
        return foundAccount;
    }

    @Override
    public Account withdrawMoney(Long accountNumber, Double amount) {
        Optional<Account> account=repo.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("No account with that accountNumber");
        }
        Account foundAccount=account.get();
        if(foundAccount.getAccountBalance() < amount){
            throw new RuntimeException("Please try a lower amount");
        }
        Double accountBalance= foundAccount.getAccountBalance() - amount;
        foundAccount.setAccountBalance(accountBalance);
        repo.save(foundAccount);
        return foundAccount;
    }

    @Override
    public Map<String, String> closeAccount(Long accountNumber) {
        Optional<Account> account=repo.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("No Account with that accountNumber");
        }
        repo.delete(account.get());
        Map<String,String> response=new HashMap<>();
        response.put("message","Account Deleted");
        return response;
    }
}
