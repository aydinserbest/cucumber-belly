package io.belly.skeleton;

public class Account {
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount; // Yeterli bakiye varsa para çekiliyor
            return true;
        } else {
            return false; // Yetersiz bakiye durumunda false dönüyoruz
        }
    }

    public int getBalance() {
        return balance;
    }
}
