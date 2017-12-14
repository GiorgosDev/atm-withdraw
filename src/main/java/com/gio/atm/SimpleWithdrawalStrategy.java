package com.gio.atm;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleWithdrawalStrategy implements WithdrawalStrategy{

    private Map<Integer, Integer> slots;
    private List<Integer> banknotesAscending;

    public SimpleWithdrawalStrategy(){}

    public SimpleWithdrawalStrategy(Map<Integer, Integer> slots) {
        setSlots(slots);
    }

    @Override
    public Map<Integer, Integer> withdraw(int requestedAmount) {
        Map<Integer,Integer> withdrawalDetails = checkWithdrawalWithBanknotes(requestedAmount);
        if(withdrawalDetails.size()>0)
            return withdrawalDetails;
        for(int banknoteValue : banknotesAscending){
            for(int i = 0; banknoteValue * i < requestedAmount; i++){
                int currentRequestedAmount = requestedAmount - banknoteValue * i;
                Map<Integer,Integer> currentWDetails = checkWithdrawalWithBanknotes(currentRequestedAmount);
                if(currentWDetails.size()>0){
                    withdrawalDetails.putAll(currentWDetails);
                    withdrawalDetails.put(banknoteValue, i);
                    return withdrawalDetails;
                }
            }
        }
        return withdrawalDetails;
    }

    public int getMinValue() throws NotEnoughMoneyException {
        return slots.keySet().stream().mapToInt(i -> i).min().orElseThrow(NotEnoughMoneyException::new);
    }

    public Map<Integer,Integer> checkWithdrawalWithBanknotes(int requestedAmount){
        Map<Integer,Integer> withdrawalDetails = new HashMap<>();
        for(int banknoteValue : banknotesAscending){
            if(requestedAmount % banknoteValue == 0 && requestedAmount/banknoteValue <= slots.get(banknoteValue)){
                withdrawalDetails.put(banknoteValue, requestedAmount/banknoteValue);
                return withdrawalDetails;
            }
        }
        return withdrawalDetails;
    }


    @Override
    public void setSlots(Map<Integer, Integer> slots) {
        this.slots = slots;
        banknotesAscending = slots.keySet().stream().sorted().collect(Collectors.toList());
    }
}
