package org.example;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            Operations.start();
        while (true) {
            System.out.println("Choose what do you want from these operations \n" +
                    "1- General \n" +
                    "2- Balance sheet \n" +
                    "3- Transaction count \n" +
                    "4- Account names with highest balances \n" +
                    "5- Recovered transaction count \n" +
                    "6- Create new account\n" +
                    "7- Exit");
            String input =scanner.next();
            if (input.equalsIgnoreCase("7")||input.equalsIgnoreCase("exit")) break;
            
            switch (input) {
                case "1":
                    System.out.print("Enter Account Number: ");
                    String accountNo =scanner.next();
                    Optional<Account> first = Operations.getAccounts().stream().filter(a -> a.getAccountNO().equalsIgnoreCase(accountNo)).findFirst();
                    first.ifPresent(account1 -> {
                        try {
                            Operations.journal(account1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    break;

                case "2":
                    System.out.println("-------------------");
                    Operations.getAccounts().forEach(account ->
                            System.out.println("Account number : "+account.getAccountNO()+"\nAccount balance : "+account.getBalance()+"\n-------------------"));
                    break;

                case "3":
                    System.out.println("Number of success transactions : "+Account.getSuccessesTransaction());
                    break;

                case "4":
                    Operations.namesWithHighest(Operations.getAccounts());
                    break;

                case "5":
                    System.out.println("Number of failed transactions : "+Account.getFailedTransaction());
                    break;

                case "6":
                    try {
                        Operations.createNewAccount();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                default:
                    System.out.println("enter a valid choice");

            }
        }
        System.out.println("Thank you!!");
    }
}