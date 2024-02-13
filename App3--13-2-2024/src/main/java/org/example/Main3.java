package org.example;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
//        String s ="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String s ="i love android and java.java is the most popular language.android is key to mobile development";
        String[] sentences = s.toLowerCase().split("\\.");
        s =s.replaceAll("\\."," ");
        String[] words = s.toLowerCase().split(" ");
        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(words));
        String[] stopWords ={"a","an","in","and","or","the","without"};
//        int[]wordWeight=new int[words.length];
        HashMap<String,Integer> wordWights =new HashMap<>();
        HashMap<String,Integer> sentWights =new HashMap<>();

        for (String s1 : set) {
            wordWights.put(s1,0);
        }

        for (int i =0; i<words.length;i++) {
            int freq = 0;
            String start = words[i];
            for (String stopWord : stopWords) {
                if (start.equalsIgnoreCase(stopWord)) i++;

            }
            for (String word : words) {
                if (start.equalsIgnoreCase(word)) {
                    freq++;
                }
            }
            wordWights.put(words[i],freq);
        }




        for (Map.Entry<String,Integer> entry:wordWights.entrySet()) {
            if(entry.getValue().equals(0)){
                wordWights.entrySet().removeIf(zm -> zm.getKey().equals(""));
            }else {
            System.out.print(entry.getKey()+" ");
            System.out.print(entry.getValue() +" ... ");
            }
        }
        System.out.println("");


        for (String sentence : sentences) {
            int freq =0;
            for (Map.Entry<String, Integer> entry : wordWights.entrySet()) {
                    if(sentence.contains(entry.getKey()))
                        freq+=entry.getValue();
            }

            sentWights.put(sentence,freq);

        }
        int max =0;
        String most="";

        for (Map.Entry<String, Integer> entry : sentWights.entrySet()) {
            if(max< entry.getValue()){
                max= entry.getValue();
                most= entry.getKey();
            }
        }
        System.out.println("The Most Important Sentence is: "+most+" with wight: "+max);
    }
}
