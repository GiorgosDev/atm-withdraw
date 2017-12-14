package com.gio.atm;

import org.junit.Assert;
import org.junit.Test;

//todo get 100 usd
//todo init
//todo banknote
//todo withdrawal
//todo atm builder
//todo withdrawal strategy
//todo get not sufficient funds message
//todo get 110 usd

public class ATMWithdrawalTest {

    @Test
    public void getOneHundredTest(){
        ATM atm = new ATM(50,20);
        Assert.assertTrue(atm.withdraw(100));
    }
}
