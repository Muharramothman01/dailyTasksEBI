import java.util.ArrayList;

public class Customer {
    private final String name;
    private final ArrayList <Laptop> laptops = new ArrayList<>();
    private final ArrayList <Mobile> phones = new ArrayList<>();


    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Laptop> getLaptops() {
        return laptops;
    }

    public void buyLaptops(Laptop laptop) {
        laptops.add(laptop);
    }

    public void removeLaptops(Laptop laptop){
        if(!laptops.isEmpty()){
            if (laptops.contains(laptop)){
                laptops.remove(laptop);
            }
            else {
                System.out.println("There is not a such a laptop like this !!!");
            }
        }
        else {
            System.out.println("There is no Laptops :)");
        }
    }

    public void buyPhones(Mobile phone) {
        phones.add(phone);
    }

    public void removePhones(Mobile phone) {
        if(!phones.isEmpty()) {
            if (phones.contains(phone)) {
                phones.remove(phone);
            }
            else {
                System.out.println("There is not a such a phone like this !!!");
            }
        }
        else {
            System.out.println("There is no Phones :)");
        }
    }

    public void showLaptops(){
        if(!laptops.isEmpty()){
            System.out.print("Laptops : \n\n========================\n");
            for (Laptop laptop : laptops
            ) {
                System.out.println(laptop.getName());
            }
            System.out.println("\n============================\n");
        }
        else{
            System.out.println("There is no Laptops :)");
        }
    }

    public void showPhones(){
        if(!phones.isEmpty()){
            System.out.print("Phones : \n\n========================\n");
            for (Mobile phone : phones
            ) {
                System.out.println(phone.getName());
            }
            System.out.println("\n============================\n");
        }
        else{
            System.out.println("There is no Phones :)");
        }
    }


    public void showRecite() {
        if (!laptops.isEmpty() || !phones.isEmpty()) {
            System.out.println("Customer Name : " + getName());
            double totalOrders = 0;
            for (Laptop laptop : laptops
            ) {
                totalOrders += laptop.getPrice();
                System.out.print("Laptops : \n\n========================\n");
                System.out.println(laptop.getName());
            }

            for (Mobile phone : phones
            ) {
                totalOrders += phone.getPrice();
                System.out.print("Phones : \n\n========================\n");
                System.out.println(phone.getName());
            }

            System.out.println("\n============================\n");
            System.out.printf("Total price : %.2f", totalOrders);
        }

        else {
            System.out.println("Your cart is empty :)");
        }
    }

}
