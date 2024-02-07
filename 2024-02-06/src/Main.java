import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String A=sc.next();
//        String s = String.valueOf(new StringBuilder(A.substring(0,A.length())).reverse());
//        System.out.println(s);
//        if(s.compareTo(A) == 0){
//            System.out.println("Yes");
//        }
//        else {
//            System.out.println("No");
//        }
//        Parent p = new Child("Hi","20","java");
        Laptop l1 = new GamingLaptop("Lenovo","IdeaGaming", (short) 16,"Core I7 gen 9th","1TB",1000);
        Laptop l2 = new Laptop("Hp","Zbook",(short) 8,"Core I5 gen 5th","512GB",250);
        Laptop l3 = new Laptop("Hp","Zbook2",(short) 8,"Core I5 gen 5th","512GB",350);
        Integer sum = 0;
        ArrayList <Integer> total = new ArrayList<Integer>();

        total.add(l1.getPrice());
        total.add(l2.getPrice());
        total.add(l3.getPrice());

        for (Integer i:total
             ) {
             sum+= i;
        }

        System.out.println("total price : "+sum);
    }
}