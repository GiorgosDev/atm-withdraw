package com.gio.atm;

import org.junit.Assert;
import org.junit.Test;

//todo get 100 usd
//todo test get amount
//todo init block
//todo banknote
//todo withdrawal
//todo atm builder <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//todo withdrawal strategy
//todo get not sufficient funds message
//todo get 110 usd

public class ATMWithdrawalTest {

    @Test
    public void initATMTest(){
        ATMBuilder builder = new ATMBuilder();
        ATM atm = builder.addBanknote(50,20).addBanknote(20,100).build();
    }

    @Test
    public void getOneHundredTest(){
        ATM atm = new ATM(50,20);
        Assert.assertTrue(atm.withdraw(100));
    }


}
