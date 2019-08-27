package com.luizhtaira.samples.acceptance;

import com.luizhtaira.samples.bank.Account;
import com.luizhtaira.samples.bank.AccountService;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.hamcrest.EasyMock2Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AccountServicesStep {

    AccountService accountService;

    private static BigDecimal total = null;
    private static final BigDecimal request = BigDecimal.valueOf(500L);
    private static final Integer accountId = 1;
    private static Account account;

    @Given("the customer is valid")
    public void user_authorization_authorized() {
        accountService = new AccountService();
        account = accountService.get(accountId);
        total = account.getTotal();
    }

    @When("the customer requests some cash")
    public void request_withdraw_accepted() {
        accountService.getCash(accountId, request);
    }

    @Then("ensure the account is debited")
    @Alias("cash is taken out")
    public void withdrawal_and_debit() {        
        Account account = accountService.get(accountId);
        assertTrue(total.compareTo(account.getTotal()) > 0);
    }

}
