package org.example;
import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String line;
        ArrayList<String> sentences = new ArrayList<>();
        ArrayList<String> wordsList = new ArrayList<>();
        Map<String,Integer> wordsMap = new HashMap<>();
        ArrayList<Integer> sentencesWeight = new ArrayList<>();
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            line= br.readLine();
            while (line!=null){
                sentences.addAll(Arrays.asList(line.split("\\.")));
                line=line.replaceAll("\\."," ");
                Pattern p = Pattern.compile("\\b(i|is|the|this|its|and|at|to|in|a|above.....)\\b\\s?");
                Matcher m = p.matcher(line);
                line=m.replaceAll("");
                wordsList.addAll(Arrays.asList(line.split(" +")));
                if (line.replaceAll("[0-9 ]+","").equalsIgnoreCase("")){
                    System.out.println("empty string");
                    return;
                }
                line= br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String word : wordsList) {
            wordsMap.put(word,0);
        }
        for (String sentence : sentences) {
            for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
                if (sentence.contains(entry.getKey())){
                    wordsMap.put(entry.getKey(), entry.getValue()+1);
                }
            }
        }
        int wordWeightSentence;
        for (String sentence : sentences) {
            wordWeightSentence=0;
            for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
                if (sentence.contains(entry.getKey())){
                    wordWeightSentence+=entry.getValue();
                }
            }
            sentencesWeight.add(wordWeightSentence);
        }
        System.out.println(sentences);
        System.out.println(sentencesWeight);
        System.out.println("the highest weight sentence is : "+sentences.get(sentencesWeight.indexOf(Collections.max(sentencesWeight))));
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter percentage of summary you want");
        double percentage=scanner.nextDouble();
        int userPercentage;
        if (percentage<0 || percentage>100){
            return;
        }
        for (double i = percentage; i >0 ; i-=10) {
            ArrayList<Integer> tmp = new ArrayList<>(sentencesWeight);
        File file = new File("F:\\projects\\test\\TextSummarize\\output\\summarize"+(int)i+"percent.txt");
            try {
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsolutePath());
                BufferedWriter bw = new BufferedWriter(fw);
                 userPercentage= (int) (i*(tmp.size()-1)/100);
                 List<Integer> indexes = new ArrayList<>();
                for (int j = tmp.size()-1; j >= ((tmp.size()-1)-userPercentage); j--) {
                    indexes.add(tmp.indexOf(Collections.max(tmp)));
                    Collections.sort(indexes);
                    tmp.set(tmp.indexOf(Collections.max(tmp)),0);
                }
                for (Integer index : indexes) {
                    bw.write(sentences.get(index)+".");
                }
                bw.close();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}