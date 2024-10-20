package org.example;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
       synchronized (this){
           if(amount > 0) {
               balance += amount;
               System.out.println(Thread.currentThread().getName() + " deposited " + amount);
           }
       }
    }

    public void withdraw(double amount) {
        synchronized (this){
            if(amount > 0 && balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount);
            }else{
                System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but didn't have enough money");
            }
        }
    }
}
