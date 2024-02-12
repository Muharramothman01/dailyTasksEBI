import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String str = "aasdas2000asdwqewq3000qweeqe9000";
//        String[] ints = str.split("\\D+");
//        int sum = 0;
//        for (int i = 1;i<ints.length;i++){
//            sum+=Integer.parseInt(ints[i]);
//        }
//        System.out.println(sum);
//
//        Array - arrayList - List

//        String[] data = {"ahmed","hany","said"};
//
//        ArrayList<String> data = new ArrayList<>();
//        data.add("ahmed");
//        data.add("hany");
//        data.add("said");
//        System.out.println(data);
//        data.add(1,"wael");
//        System.out.println(data);
//        System.out.println(data.get(1));
//        data.remove(1);
//        System.out.println(data);
//        data.add("");
//        data.set(3,"sayed");
//        System.out.println(data);

//        String[] data = {"ahmed","hany","said"};
//        for (String datum : data) {
//            if(datum.equals("hany")){
//                System.out.println("Found");
//                break;
//            }
//        }
//

//        ArrayList<String> data = new ArrayList<>();
//        data.add("Ahmed");
//        data.add("hany");
//        data.add("wael");
//        data.add("tamer");
//
//        ArrayList<String> copy = new ArrayList<>();
//        copy.add("Monika");
//        copy.add("Mariem");
//        copy.add("mike");
//
//        data.addAll(0,copy);

//        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).equals("wael")){
//                System.out.println("Found");
//                break;
//            }
//            else if(data.size()-1 == i){
//                System.out.println("Not Found");
//            }
//        }

//        if(data.contains("wael")){
//            System.out.println("found");
//            System.out.println(data.indexOf("wael"));
//        }
//        else{
//            System.out.println("not found");
//        }
//        System.out.println(data);

//        data.removeAll(copy);
//        data.clone();
//        System.out.println(data);
//        data.clear();
//        System.out.println(data);

//        System.out.println(data.subList(1,5));
//        List<String> subList = data.subList(1,5);
//        System.out.println(subList);
//        subList.add("xoxo");
//        System.out.println(subList);
//        data.removeAll(copy);
//        System.out.println(data.clone());

//          String[] data = {"Ahmed","said","wael"};
//          List<String> result = Arrays.asList(data);
//          Arrays.sort(data);
//        System.out.println(Arrays.toString(data));
//        System.out.println(Arrays.binarySearch(data,"wael")); // it should be sorted, and it will return a index of the element that we searched for.
//        String[] copy = Arrays.copyOf(data, data.length);
//        System.out.println(Arrays.toString(data));
//        System.out.println(Arrays.toString(copy));
//
//        Arrays.fill(data,"");
//        System.out.println(Arrays.toString(data));


//        ArrayList<String> data = new ArrayList<>();
//        ArrayList<Integer> numbers = new ArrayList<>();
//
//        Collections.addAll(data, "ahmed", "tamer", "wael","ahmed");
//        System.out.println(data);

        //Collections.fill(data,"");
        //System.out.println(data);
        //System.out.println(Collections.frequency(data,"ahmed"));
//        System.out.println(Collections.max(data));
//        System.out.println(Collections.min(data));
//        List<Integer> nCopies = Collections.nCopies(5,1); // length, value
//        System.out.println(nCopies.getClass());
//        System.out.println(nCopies);

//        Collections.replaceAll(data, "ahmed", "hany");
//        System.out.println(data);
//        Collections.reverse(data);
//        System.out.println(data);
//        Collections.rotate(data,1); // collections, number of shifts
//        System.out.println(data);
//
//        Collections.shuffle(data);
//        System.out.println(data);
//
//        Collections.swap(data,0,3); // collections, Index 1, Index 2
//        System.out.println(data);

//        String statement = "i love android i love java";
//        String[] array = statement.split(" ");
//        List<String> list = Arrays.asList(array);
////        List<String> l2 = new ArrayList<>();
//        for(String s: list){
////            if(!l2.contains(s)){
////                int f = Collections.frequency(list,s);
////                System.out.println(s+" "+f);
////                l2.add(s);
////            }
////            else {
////                continue;
////            }
//            if (s.isEmpty())
//                continue;
//            int f = Collections.frequency(list,s);
//                System.out.println(s+" "+f);
//                Collections.replaceAll(list,s,"");
    
    Scanner s = new Scanner(System.in);
    List<String> egypt = Arrays.asList("Cairo, alex");
    System.out.println("Enter three cities in egypt");
    String ans = s.next();
    ArrayList<String> user = new ArrayList<>();
        for (String s1:
             egypt) {

        }
        
        
    }
}
