package org.example;

public class Account {
    private String name;
    private String accountNO;
    private double balance;
    private static  int successesTransaction;
    private static  int failedTransaction;

    private Account() {
    }

    public Account(String name, String accountNO, double balance) {
        this.name = name;
        this.accountNO = accountNO;
        this.balance = balance;
    }
    public void deposit(double amount) throws BankException {
        if (amount<=0){
            failedTransaction++;
            throw new BankException(ErrorCode.NEGATIVEVALUE);
        }
        balance+=amount;
        successesTransaction++;
        System.out.println("Your current balance : "+balance);
    }

    public void withdraw(double amount) throws BankException {
        if (amount<=0){
            failedTransaction++;
            throw new BankException(ErrorCode.NEGATIVEVALUE);
        }
        if (balance<amount){
            failedTransaction++;
            throw new BankException(ErrorCode.INSUFFENCTVALUE);
        }

        balance-= amount;
        successesTransaction++;
        System.out.println("Your current balance : "+balance);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNO() {
        return accountNO;
    }

    public void setAccountNO(String accountNO) {
        this.accountNO = accountNO;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static int getSuccessesTransaction() {
        return successesTransaction;
    }

    public static int getFailedTransaction() {
        return failedTransaction;
    }
}
