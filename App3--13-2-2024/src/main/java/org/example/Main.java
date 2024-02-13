package org.example;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> films = Arrays.asList("saw","it","final destination","captain america","warm bodies","mission impossible");
        List<String> categories = Arrays.asList("horror","horror","horror","action","horror","action");
        List<Integer>filmsFreqs= new ArrayList<>(Collections.nCopies(films.size(),0));
        List<Integer>cateFreqs= new ArrayList<>(Collections.nCopies(films.size(),0));


        search(scan, films, categories, filmsFreqs, cateFreqs);
        getMostSearch(films, categories, filmsFreqs, cateFreqs);


    }

    private static void getMostSearch(List<String> films, List<String> categories, List<Integer> filmsFreqs, List<Integer> cateFreqs) {
        int maxFilm = Collections.max(filmsFreqs);
        int maxCate = Collections.max(cateFreqs);
        int indexFilm = filmsFreqs.indexOf(maxFilm);
        int indexCate = cateFreqs.indexOf(maxCate);
        System.out.println("The most Searched Movie: "+ films.get(indexFilm));
        System.out.println("The most Searched Category: "+ categories.get(indexCate));
    }

    private static void search(Scanner scan, List<String> films, List<String> categories, List<Integer> filmsFreqs, List<Integer> cateFreqs) {
        while (true){
            System.out.println("Enter input");
            String inp = scan.nextLine();

            if(!(films.contains(inp)) && !(categories.contains(inp))){
                System.out.println("Wrong Data!");
                break;
            }
            if(inp.equalsIgnoreCase("exit"))break;
            for (int i = 0; i < films.size(); i++) {
                if (inp.equalsIgnoreCase(films.get(i))){
                    System.out.println(films.get(i)+" is Classified as "+ categories.get(i)+" Category");
                    filmsFreqs.set(i, filmsFreqs.get(i)+1);
                    break;
                }else if(inp.equalsIgnoreCase(categories.get(i))){
                    for (int j = 0; j < films.size(); j++) {
                        if(categories.get(j).equalsIgnoreCase(categories.get(i))){
                            System.out.println(films.get(j));
                        }
                    }
                    cateFreqs.set(i, cateFreqs.get(i)+1);
                    break;
                }
            }
        }
    }

}