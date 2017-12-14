package com.gio.atm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//todo get 100 usd <<<<<<<<<<<<<<<<<<<<<<
//todo test get amount
//init block
//todo banknote
//todo withdrawal
//atm builder
//todo withdrawal strategy
//todo get not sufficient funds message
//todo get 110 usd

public class ATMWithdrawalTest {

    @Test
    public void initATMTest(){
        Assert.assertEquals(3000, atm.getBalanceAvailable());
    }

    @Test
    public void getOneHundredTest(){
        Assert.assertTrue(atm.withdraw(100));
    }

    @Before
    public void init(){
        ATMBuilder builder = new ATMBuilder();
        atm = builder.addBanknote(50,20).addBanknote(20,100).build();
    }

    private ATM atm;
}
