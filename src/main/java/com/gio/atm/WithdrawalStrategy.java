package com.gio.atm;

import java.util.Map;

public interface WithdrawalStrategy {

    public Map<Integer, Integer> withdraw(int requestedAmount);

    public void setSlots(Map<Integer, Integer> slots);
}
