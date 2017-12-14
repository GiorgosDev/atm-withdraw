package com.gio.atm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ATMWithdrawalTest {

    @Test
    public void initATMTest(){
        ATMBuilder builder = new ATMBuilder();
        atm = builder.addBanknote(50,20).addBanknote(20,50).build();
        Assert.assertEquals(2000, atm.getBalanceAvailable());
    }

    @Test
    public void withdrawalTest() throws NotEnoughMoneyException {
        int initAmount = atm.getBalanceAvailable();
        Assert.assertTrue(atm.withdraw(100).size()>0);
        Assert.assertEquals(initAmount-100, atm.getBalanceAvailable());

        initAmount = atm.getBalanceAvailable();
        Assert.assertTrue(atm.withdraw(210).size()>0);
        Assert.assertEquals(initAmount-210, atm.getBalanceAvailable());

        initAmount = atm.getBalanceAvailable();
        Assert.assertTrue(atm.withdraw(130).size()>0);
        Assert.assertEquals(initAmount-130, atm.getBalanceAvailable());
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void notEnoughMoneyTest() throws NotEnoughMoneyException {
        Assert.assertTrue(atm.withdraw(5210).size()>0);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void notMoneyTest() throws NotEnoughMoneyException {
        Assert.assertTrue(atm.withdraw(21).size()>0);
    }


    @Before
    public void init(){
        ATMBuilder builder = new ATMBuilder();
        atm = builder.addBanknote(50,20).addBanknote(20,100).build();
    }

    private ATM atm;
}
