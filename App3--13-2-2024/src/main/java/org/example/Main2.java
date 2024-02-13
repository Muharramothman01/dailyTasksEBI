package org.example;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> films = Arrays.asList("saw","it","final destination","captain america","warm bodies","mission impossible");
        List<String> categories = Arrays.asList("horror","horror","horror","action","horror","action");
        HashMap<String,String> movie = new HashMap<>();
        HashMap<String,Integer> f1 = new HashMap<>();
        HashMap<String,Integer> f2 = new HashMap<>();
        int c=0;
        for (int i = 0; i < films.size(); i++) {
            movie.put(films.get(i),categories.get(i));
            f1.put(films.get(i),0);
            f1.put(categories.get(i),0);
        }
//        List<Integer>filmsFreqs= new ArrayList<>(Collections.nCopies(movie.size(),0));
//        List<Integer>cateFreqs= new ArrayList<>(Collections.nCopies(movie.size(),0));
        operation(scan, movie, f1, f2);
        System.out.println(f1.get("saw"));
//        int maxFilm = Collections.max(filmsFreqs);
//        int maxCate = Collections.max(cateFreqs);
//        int indexFilm = filmsFreqs.indexOf(maxFilm);
//        int indexCate = cateFreqs.indexOf(maxCate);
//        if(maxFilm==0 ){
//            System.out.println("no searches for any movie");
//            System.out.println("The most Searched Category: " + categories.get(indexCate));
//        }else if(maxCate==0){
//            System.out.println("The most Searched Movie: " + films.get(indexFilm));
//            System.out.println("no searches for any Category");
//        }else {
//            System.out.println("The most Searched Movie: " + films.get(indexFilm));
//            System.out.println("The most Searched Category: " + categories.get(indexCate));
//        }

    }

    private static void operation(Scanner scan, HashMap<String, String> movie,HashMap <String,Integer> f1,HashMap <String,Integer> f2) {

        while (true) {
            System.out.println("Enter input");
            String inp = scan.nextLine();
            if (inp.equalsIgnoreCase("exit")) {
                return;
            }
            if (!movie.containsKey(inp) && !movie.containsValue(inp)) {
                System.out.println("Wrong Data!");
            } else {

                for (Map.Entry<String, String> enrty : movie.entrySet()) {

                    if (inp.equalsIgnoreCase(enrty.getKey())) {
                        System.out.println(enrty.getKey() + " is Calssified as " + enrty.getValue());
                        f1.put(enrty.getKey(), f1.get(enrty.getKey())+1);
                        break;
                    } else if (inp.equalsIgnoreCase(enrty.getValue())) {
                        for (Map.Entry<String, String> enrty2 : movie.entrySet()) {
                            if (enrty2.getValue().equalsIgnoreCase(inp)) {
                                System.out.println(enrty2.getKey());

                            }

                        }
                        break;
                    }

                }
            }
        }
    }
}
