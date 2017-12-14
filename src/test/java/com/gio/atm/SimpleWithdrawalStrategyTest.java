package com.gio.atm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SimpleWithdrawalStrategyTest {

    @Test
    public void minSlotTest() throws NotEnoughMoneyException {
        Assert.assertEquals(20, strategy.getMinValue());
    }

    @Test
    public void withdrawOneHundred() throws NotEnoughMoneyException {
        Map<Integer,Integer> withdrawal = strategy.withdraw(100);
        Assert.assertEquals(1, withdrawal.size());
        Assert.assertEquals(new Integer(5), withdrawal.get(20));
    }

    @Test
    public void withdrawOneHundredTen() throws NotEnoughMoneyException {
        Map<Integer,Integer> withdrawal = strategy.withdraw(110);
        Assert.assertEquals(2, withdrawal.size());
        Assert.assertEquals(new Integer(3), withdrawal.get(20));
        Assert.assertEquals(new Integer(1), withdrawal.get(50));
    }

    @Before
    public void init(){
        slots.clear();
        slots.put(20,10);
        slots.put(50,5);
        strategy.setSlots(slots);
    }

    SimpleWithdrawalStrategy strategy = new SimpleWithdrawalStrategy();
    Map<Integer, Integer> slots = new HashMap<>();
}
