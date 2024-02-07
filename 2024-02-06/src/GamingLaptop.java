public class GamingLaptop extends Laptop{
    private String graphicCard;
    private short resolution;

    public GamingLaptop(String name, String model, short ram, String process, String storage,int price) {
        super(name, model, ram, process, storage,price);
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public short getResolution() {
        return resolution;
    }

    public void setResolution(short resolution) {
        this.resolution = resolution;
    }


    public void buyGaming(){
        System.out.println("You buy a gaming laptop");
    }

}
