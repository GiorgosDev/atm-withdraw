package com.gio.atm;

import java.util.HashMap;
import java.util.Map;

public class ATM {

    private Map<Integer, Integer> moneySlots = new HashMap<>();

    private WithdrawalStrategy withdrawalStrategy = new SimpleWithdrawalStrategy(moneySlots);

    public Map<Integer, Integer> withdraw(int requestedAmount) throws NotEnoughMoneyException {
        if(requestedAmount>getBalanceAvailable())
            throw new NotEnoughMoneyException();
        withdrawalStrategy.setSlots(moneySlots);
        Map<Integer, Integer> withdrawalDetails = withdrawalStrategy.withdraw(requestedAmount);
        if(withdrawalDetails.size() == 0)
            throw new NotEnoughMoneyException();
        applyWithdrawal(withdrawalDetails);
        return withdrawalDetails;
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

    private void applyWithdrawal(Map<Integer, Integer> withdrawalDetails){
        for(int key : withdrawalDetails.keySet()){
            int currentAmount = moneySlots.get(key);
            int withdrawalAmount = withdrawalDetails.get(key);
            if(currentAmount == withdrawalAmount)
                moneySlots.remove(key);
            else
                moneySlots.put(key, currentAmount - withdrawalAmount);
        }
    }

    public Map<Integer, Integer> getMoneySlots() {
        return moneySlots;
    }
}
