import java.util.ArrayList;

public class Storage {
    private ArrayList<Laptop> laptops;
    private ArrayList<Mobile> phones;

    public Storage(ArrayList<Laptop> laptops, ArrayList<Mobile> phones) {
        this.laptops = laptops;
        this.phones = phones;
    }

    public Storage() {
    }

    public ArrayList<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(ArrayList<Laptop> laptops) {
        this.laptops = laptops;
    }

    public ArrayList<Mobile> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<Mobile> phones) {
        this.phones = phones;
    }

    public void showLaptops(){
        if(!laptops.isEmpty()){
            System.out.print("Laptops : \n\n========================\n");
            for (Laptop laptop : laptops) {
                System.out.println(laptop.getName());
            }
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
        }
        else{
            System.out.println("There is no Laptops :)");
        }
    }


    public Laptop getLaptop(String name){

        if(!getLaptops().isEmpty()){

            for (Laptop laptop: getLaptops()) {
                if(laptop.getName().equalsIgnoreCase(name)){
                    return laptop;
                }
            }
        }
        else{
            System.out.println("There is no Laptops :)");
        }
        return null;
    }


    public Mobile getPhone(String name){
        if(!getPhones().isEmpty()){
            for (Mobile phone:
                    getPhones()) {
                if(phone.getName().equalsIgnoreCase(name)){
                    return phone;
                }
            }
        }
        else{
            System.out.println("There is no Phones :)");
        }
        return null;
    }


}
