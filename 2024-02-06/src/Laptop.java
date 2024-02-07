public class Laptop {
    private String name;
    private String model;
    private short ram;
    private String process;
    private String storage;
    private int price;
    public Laptop(String name, String model, short ram, String process,String storage,int price) {
        this.name = name;
        this.model = model;
        this.ram = ram;
        this.process = process;
        this.storage = storage;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getRam() {
        return ram;
    }

    public void setRam(short ram) {
        this.ram = ram;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
    public void buyNormal(){
        System.out.println("You buy a new normal laptop");
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
