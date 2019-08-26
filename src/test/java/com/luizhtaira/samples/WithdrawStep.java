package com.luizhtaira.samples;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class WithdrawStep {

    private int total = 500;
    private int withdraw = 100;

    @Given("um usuário efetuando um saque")
    public void user_make_withdraw() {
        System.out.println("realizar um saque");
    }

    @When("ele possuir saldo na conta")
    public void check_user_amount() {
        System.out.println("Verifica o saldo");
    }

    @Then(" o saque será efetuado")
    public void theValueOfTheCounterMustBe1Greater() {
        System.out.println("Saldo positivo: saque efetuado");
        assertTrue(total > withdraw);
    }

}
