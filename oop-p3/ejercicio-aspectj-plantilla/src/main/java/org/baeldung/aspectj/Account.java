package org.baeldung.aspectj;

public class Account {
    int balance = 20;

    public Account() {}
    public Account(int balance) {
        this.balance = balance;
    }
    public int getBalance() {
        return this.balance;
    }
    public boolean withdraw(int amount) {
        if (balance < amount) {
            return false;
        }
        balance = balance - amount;
        return true;
    }
}
