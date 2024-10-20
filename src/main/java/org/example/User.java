package org.example;

public class User implements Runnable{
    private String name;
    private BankAccount bankAccount;
    private boolean depositOperation;
    private int amount;

    public User(String name, BankAccount bankAccount, boolean depositOperation, int amount) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.depositOperation = depositOperation;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        if(depositOperation){
            bankAccount.deposit(this.amount);
        }else{
            bankAccount.withdraw(this.amount);
        }
    }
}
