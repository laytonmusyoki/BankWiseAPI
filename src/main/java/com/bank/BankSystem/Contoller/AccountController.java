package com.bank.BankSystem.Contoller;

import com.bank.BankSystem.Entity.Account;
import com.bank.BankSystem.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    AccountService service;

    @RequestMapping("account")
    @GetMapping("/")
    public List<Account> getAllBankDetails(){
        List<Account> account=service.getAllAccountDetails();
        return account;
    }

    @PostMapping("/create")
    public ResponseEntity createAccount(@RequestBody Account account){
        Map<String,String> response=service.createAccount(account);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountDetails(@PathVariable Long accountNumber){
        Account account=service.getBankDetailsByAccountNumber(accountNumber);
        return account;
    }

    @PutMapping("deposit/{id}/{amount}")
    public Account depositAmount(@PathVariable Long id,@PathVariable Double amount){
        Account account=service.depositAmount(id,amount);
        return account;
    }

    @PutMapping("withdraw/{id}/{amount}")
    public Account withdrawAmount(@PathVariable Long id,@PathVariable Double amount){
        Account account=service.withdrawMoney(id,amount);
        return account;
    }

    @DeleteMapping("delete/{accountNumber}")
    public ResponseEntity deleteAccount(@PathVariable Long accountNumber){
        Map<String,String> response=service.closeAccount(accountNumber);
        return ResponseEntity.ok(response);
    }
}
