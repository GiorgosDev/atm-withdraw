package com.gio.atm;

public class ATM {

    private int amountFifties = 0;
    private int amountTwenties = 0;


    public ATM(int amountFifties, int amountTwenties) {
        this.amountFifties = amountFifties;
        this.amountTwenties = amountTwenties;
    }

    public boolean withdraw(int requestedAmount) {
        return true;
    }

    public int getBalanceAvailable() {
        return 3000;
    }
}
