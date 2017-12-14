package com.gio.atm;

import java.util.HashMap;
import java.util.Map;

public class ATMBuilder {

    private Map<Integer, Integer> slots = new HashMap<>();
    private WithdrawalStrategy strategy;

    public ATMBuilder addBanknote(int value, int amount) {
        slots.put(value, amount);
        return this;
    }

    public ATMBuilder addWithdrawalStrategy(WithdrawalStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public ATM build() {
        ATM atm = new ATM();
        atm.setMoneySlots(slots);
        atm.setWithdrawalStrategy(strategy);
        return atm;
    }

}
