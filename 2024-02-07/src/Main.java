import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("1 - Laptops");
        System.out.println("2 - Phones");
        System.out.println("3 - Show Recite");
        System.out.println("4 - Show Phones in your cart");
        System.out.println("5 - Show Laptops in your cart");
        System.out.println("6 - Remove Laptop from your cart");
        System.out.println("7 - Remove Phone from your cart");
        System.out.println("0 - to Exit");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String customerName;
        Storage storageShop = new Storage();
        Laptop l1 = new Laptop("Lenovo","Idea Pad Gaming",1000.0);
        Laptop l2 = new Laptop("Hp","Zbook",500.0);
        Mobile p1 = new Mobile("Xiaomi","poke",200.0);
        Mobile p2 = new Mobile("Samsung","Galaxy",400);
        ArrayList <Laptop> laptops = new ArrayList<>();
        ArrayList <Mobile> phones = new ArrayList<>();
        laptops.add(l1);
        laptops.add(l2);
        phones.add(p1);
        phones.add(p2);

        storageShop.setLaptops(laptops);
        storageShop.setPhones(phones);

        System.out.println("Welcome sir, please Enter your name");
        customerName = input.nextLine();
        Customer customer1 = new Customer(customerName);
        System.out.println("How can I help you ?");
        while (true){
            menu();
            System.out.println("=======================================");
            int option = input.nextInt();
            if(option == 1){
                storageShop.showLaptops();
                System.out.println("Write what do you want from these laptops by writing its name correctly");
                String selection = input.next();
                customer1.buyLaptops(storageShop.getLaptop(selection));
            }
            else if(option == 2){
                storageShop.showPhones();
                System.out.println("Write what do you want from these phones by writing its name correctly");
                String selection = input.next();
                customer1.buyPhones(storageShop.getPhone(selection));
            }
            else if(option == 3){
                customer1.showRecite();
            }
            else if(option == 4){
                customer1.showPhones();
            }
            else if(option == 5){
                customer1.showLaptops();
            }
            else if (option == 6){
                customer1.showLaptops();
                System.out.println("Write what do you want from these to remove by writing its name correctly");
                String selection = input.next();
                customer1.removeLaptops(storageShop.getLaptop(selection));
            }
            else if (option == 7){
                customer1.showPhones();
                System.out.println("Write what do you want from these to remove by writing its name correctly");
                String selection = input.next();
                customer1.removePhones(storageShop.getPhone(selection));
            }
            else if (option == 0){
                System.out.println("Thank you :)");
                break;
            }

            else {
                System.out.println("Invalid Choice");
                continue;
            }

            System.out.println("\n=======================================\n");
        }
    }
}