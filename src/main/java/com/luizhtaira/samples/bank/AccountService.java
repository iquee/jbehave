package com.luizhtaira.samples.bank;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class AccountService {

    public static HashMap<Integer, Account> customers;

    public AccountService() {
        if (customers == null) {
            customers = new HashMap<>();
            customers.put(1, (new Account("Luiz", "luiz@luiz.com", BigDecimal.valueOf(5000L))));
            customers.put(2, (new Account("Ana", "ana@ana.com", BigDecimal.valueOf(1000L))));
            customers.put(3, new Account("Maria", "maria@maria.com", BigDecimal.valueOf(500L)));
        }
    }

    public void getCash(Integer id, BigDecimal value){
        Account account = get(id);
        account.setTotal(account.getTotal().subtract(value));
        customers.put(id, account);
    }

    public Account get(Integer id){
        return customers.get(id);
    }

    public Integer create(Account account){
        Integer id = customers.size() + 1;
        customers.put(id, account);
        return id;
    }
}