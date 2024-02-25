package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public abstract class  Operations {
    private static List<String> dataSheet = new ArrayList<>();;
    private static ArrayList<String> accountDetails  = new ArrayList<>();
    private static ArrayList<Account> accounts = new ArrayList<>();

    public static void start() throws IOException {
        dataSheet=  showBalanceSheet();
            if (dataSheet.isEmpty()) {
                System.out.println("No Accounts yet;\nPlease Create Account");
                Operations.createNewAccount();
            }
            dataSheet.stream().filter(a -> !a.equalsIgnoreCase("null")).forEach(a ->
                    accountDetails.add(Arrays.toString(a.split(",")))
            );
            for (String accountDetail : accountDetails) {
                accountDetail= accountDetail.replace("[","").replace("]","");
                accounts.add(new Account(accountDetail.split(",")[0].trim(),
                        accountDetail.split(",")[1].trim(),
                        Double.parseDouble(accountDetail.split(",")[2].trim())));
            }
    }
    public static List<String> showBalanceSheet() throws IOException {
        return Files.readAllLines(Paths.get("bankentry.txt"));
    }
    public static void journal(Account account) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello : "+account.getName());
        while (true){
            System.out.println("Enter the operation\n" +
                    "1 - to credit(deposit)\n" +
                    "2 - to debit(withdraw)\n" +
                    "3 - exit");
            String input =scanner.next();
            if (input.equalsIgnoreCase("exit")||input.equalsIgnoreCase("3")) break;
            try {
                switch (input){
                    case "1":
                        System.out.println("enter amount to Credit");
                        account.deposit(scanner.nextDouble());
                        updateData();
                        break;
                    case "2":
                        System.out.println("enter amount to Debit");
                        account.withdraw(scanner.nextDouble());
                        updateData();
                        break;
                    default:
                        System.out.println("enter a valid input");
                }
            } catch (BankException e){
                System.out.println(e.getMessage()+"\n-------------------");
            }
        }
    }

    public static void namesWithHighest(){
        accounts.stream()
                .sorted(Comparator.comparing(Account::getBalance).reversed()).limit(5)
                .forEach(account -> System.out.println(
                        "Account balance : "+account.getBalance()+
                        "\nAccount number : "+account.getAccountNO()+
                        "\nHolder Name : "+account.getName()+
                        "\n-------------------")
                );
    }

    public static void createNewAccount() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String uniqueID = UUID.randomUUID().toString().replaceAll("\\D","").substring(0,8);
        FileWriter fw = new FileWriter("bankentry.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        System.out.println("enter account holder name");
        String name = scanner.nextLine();
        bw.write(name+","+uniqueID+",");
        System.out.println("enter account balance");
        double balance = scanner.nextDouble();
        bw.write(balance+"".trim());
        bw.newLine();
        bw.close();
        fw.close();
        System.out.println("account created successfully");
        accounts.add(new Account(name,uniqueID,balance));
    }
    public static Account createNewAccount(String id) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter fw = new FileWriter("bankentry.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        System.out.println("enter account holder name");
        String name =scanner.nextLine();
        bw.write(name+","+id+",");
        System.out.println("enter account balance");
        double balance = scanner.nextDouble();
        bw.write(balance+"".trim());
        bw.newLine();
        bw.close();
        fw.close();
        System.out.println("account created successfully");
        Account account =new Account(name,id,balance);
        accounts.add(account);
        return account;
    }
    public static void updateData() throws IOException {
        FileWriter fw =new FileWriter("bankentry.txt");
        BufferedWriter bw =new BufferedWriter(fw);
        for (Account account : accounts) {
            bw.write(account.getName()+","+account.getAccountNO()+","+account.getBalance());
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
    public static ArrayList<Account> getAccounts() {
        return accounts;
    }
}
