package com.gio.atm;

public class ATMBuilder {
    public ATMBuilder addBanknote(int value, int amount) {
        return this;
    }

    public ATM build() {
        return new ATM(0,0);
    }
}
