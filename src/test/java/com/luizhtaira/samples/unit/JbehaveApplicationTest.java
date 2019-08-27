package com.luizhtaira.samples.unit;

import com.luizhtaira.samples.bank.Account;
import com.luizhtaira.samples.bank.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class JbehaveApplicationTest {

    AccountService accountService;

    @Autowired
    public JbehaveApplicationTest(AccountService accountService){
        this.accountService = accountService;
    }

    @Test
    public void account_create_created(){
        Account account = new Account("Ze", "ze@ze.com", BigDecimal.valueOf(2000L));
        Integer id = accountService.create(account);
        Account created = accountService.get(id);
        assertNotNull(created);
    }

}
