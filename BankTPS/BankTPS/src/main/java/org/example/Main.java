package org.example;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            try {
                Operations.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Choose what do you want from these operations \n" +
                    "1- Journal \n" +
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
                    System.out.print("Enter Account Number from 8 digits as minimum : ");
                    String accountNo =scanner.next().replaceAll("[\\D]","").trim();
                    if(accountNo.length() < 8){
                        System.out.println("Enter valid account number !");
                        break;
                    }
                    Optional<Account> first = Operations.getAccounts().stream().filter(a -> a.getAccountNO().equalsIgnoreCase(accountNo)).findFirst();
                    if (!first.isPresent()){
                        System.out.println("account number doesn't exist");
                        System.out.println("Create an account with this account number");

                        first.ifPresent(account1 -> {
                            try {
                                Operations.journal(Operations.createNewAccount(accountNo));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                    else {
                        first.ifPresent(account1 -> {
                            try {
                                Operations.journal(account1);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                    break;

                case "2":
                    System.out.println("-------------------");
                    try {
                        Operations.showBalanceSheet().forEach(account ->
                                        System.out.println(
                                                "Account Holder Name : "+account.split(",")[0].trim()
                                                +"\nAccount Number : "+ account.split(",")[1].trim()
                                                +"\nAccount Balance :"+account.split(",")[2].trim()
                                                +"\n-------------------")
                        );
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "3":
                    System.out.println("-------------------");
                    System.out.println("Number of success transactions : "+Account.getSuccessesTransaction());
                    System.out.println("-------------------");
                    break;

                case "4":
                    System.out.println("-------------------");
                    Operations.namesWithHighest(Operations.getAccounts());
                    break;

                case "5":
                    System.out.println("-------------------");
                    System.out.println("Number of failed transactions : "+Account.getFailedTransaction());
                    System.out.println("-------------------");
                    break;

                case "6":
                    try {
                        Operations.createNewAccount();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                default:
                    System.out.println("Enter a valid choice !");

            }
        }
        System.out.println("Thank you!!");
    }
}