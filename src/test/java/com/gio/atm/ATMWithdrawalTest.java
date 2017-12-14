package com.gio.atm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//todo get 100 usd
//test get amount
//init block
//moneySlot
//todo withdrawal
//atm builder
//withdrawal strategy
//todo get not sufficient funds message
//todo get 110 usd

public class ATMWithdrawalTest {

    @Test
    public void initATMTest(){
        ATMBuilder builder = new ATMBuilder();
        atm = builder.addBanknote(50,20).addBanknote(20,50).build();
        Assert.assertEquals(2000, atm.getBalanceAvailable());
    }

    @Test
    public void getOneHundredTest(){
        int initAmount = atm.getBalanceAvailable();
        Assert.assertTrue(atm.withdraw(100));
        Assert.assertEquals(initAmount-100, atm.getBalanceAvailable());
    }

    @Before
    public void init(){
        ATMBuilder builder = new ATMBuilder();
        atm = builder.addBanknote(50,20).addBanknote(20,100).build();
    }

    private ATM atm;
}
