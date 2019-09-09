package com.github.iquee.acceptance;

import com.github.iquee.bank.account.Account;
import com.github.iquee.bank.account.AccountService;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

@Component
public class AccountServicesStep {

    @Autowired
    AccountService accountService;

    private static final BigDecimal value = BigDecimal.valueOf(500L);
    private static final Integer accountId = 1;
    private static Account account;

    @Given("the account is in credit")
    @Alias("the customer is valid")
    public void user_authorization_authorized() {
        account = accountService.get(accountId);
    }

    @When("the customer requests some cash")
    public void request_withdraw_accepted() {
        accountService.getCash(accountId, value);
    }

    @Then("ensure the account is debited")
    @Alias("cash is taken out")
    public void withdrawal_and_update_total_ammount() {
        Account accountUpdated = accountService.get(accountId);
        assertTrue(account.getTotal().compareTo(accountUpdated.getTotal()) > 0);
    }

}
