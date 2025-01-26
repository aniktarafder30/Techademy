package Techademy.q1.src.main.java.com.sdet.anik.client;

import Techademy.q1.src.main.java.com.sdet.anik.CurrentAccount;
import Techademy.q1.src.main.java.com.sdet.anik.Account;
import Techademy.q1.src.main.java.com.sdet.anik.SavingsAccount;

public class App {
    public static void main(String[] args) {
        Account current = new CurrentAccount(1000);
        Account savings = new SavingsAccount(100, 10, 1);
        System.out.println("current balance: " + current.calculateInterest());
        System.out.println("savings balance: " + savings.calculateInterest());
    }
}