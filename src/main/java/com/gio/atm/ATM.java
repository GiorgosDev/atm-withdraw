package com.gio.atm;

import java.util.HashMap;
import java.util.Map;

public class ATM {

    private Map<Integer, Integer> moneySlots = new HashMap<>();

    private WithdrawalStrategy withdrawalStrategy;

    public boolean withdraw(int requestedAmount) {

        return true;
    }

    public int getBalanceAvailable() {
        return moneySlots.entrySet().stream().mapToInt(e -> e.getKey()*e.getValue()).sum();
    }

    public void setMoneySlots(Map<Integer, Integer> moneySlots) {
        this.moneySlots = moneySlots;
    }

    public void setWithdrawalStrategy(WithdrawalStrategy withdrawalStrategy) {
        this.withdrawalStrategy = withdrawalStrategy;
    }
}
