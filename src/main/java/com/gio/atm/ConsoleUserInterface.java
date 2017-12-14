package com.gio.atm;

import java.util.Map;
import java.util.Scanner;

public class ConsoleUserInterface {
    public static void main(String[] args){
        System.out.println("Welcome to ATM");
        System.out.println("Please set up the ATM buy adding money to slots.");
        System.out.println("Please enter 1 - to add money, any other - complete the set up process.");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        ATMBuilder builder = new ATMBuilder();
        while (command == 1){
            System.out.println("Please enter the value of banknote to be added.");
            int value = scanner.nextInt();
            if(value <= 0){
                System.out.println("Incorrect data");
            }
            System.out.println("Please enter the amount of banknote to be added.");
            int amount = scanner.nextInt();
            if(amount <= 0){
                System.out.println("Incorrect data");
            }
            builder.addBanknote(value,amount);
            System.out.println("Please enter 1 - to add money, any other - complete the set up process.");
            command = scanner.nextInt();
        }
        System.out.println("The set up was completed successfully.");
        ATM atm = builder.build();
        System.out.println("Available amount:" + atm.getBalanceAvailable());
        System.out.println("Please enter 1 - to withdraw, any other - to exit");
        command = scanner.nextInt();
        while (command == 1){
            System.out.println("Please enter amount requested");
            int requestedAmount = scanner.nextInt();
            if(requestedAmount <= 0){
                System.out.println("Incorrect data");
            }
            try {
                Map<Integer,Integer> details = atm.withdraw(requestedAmount);
                System.out.println("Withdrawal completed successfully, please see the details below");
                System.out.println("value\t\t\tamount");
                details.entrySet().forEach(e -> System.out.println(e.getKey() + "\t\t\t" + e.getValue()));
                System.out.println("Total:\t\t\t"+requestedAmount);
            } catch (NotEnoughMoneyException e) {
                System.out.println("The requested amount of money can't be provided by ATM");
            }
            System.out.println("Available amount:" + atm.getBalanceAvailable());
            System.out.println("Please enter 1 - to withdraw, any other - to exit");
            command = scanner.nextInt();
        }
    }
}
