import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int total;
        int percentage;
        String path;
        StringBuilder s = new StringBuilder();


        System.out.println("Enter the path : ");
        path = input.nextLine().replace("\\","\\\\");
        File file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try (FileReader fileReader = new FileReader(path);
                 BufferedReader br = new BufferedReader(fileReader)
            ){
                while (br.readLine() != null){
                       s.append(br.readLine());
                    System.out.println(s);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(s.toString().replaceAll("[ 0-9]+", "").isEmpty()){
            System.out.println("Wrong Data!");
            return;
        }
        HashSet <String> stopWordsSet = new HashSet<>(Arrays.asList(
                "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at",
                "be", "because", "been", "before", "being", "below", "between", "both", "but", "by",
                "can't", "cannot", "could", "couldn't",
                "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during",
                "each",
                "few", "for", "from", "further",
                "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll", "he's", "her", "here",
                "here's", "hers", "herself", "him", "himself", "his", "how", "how's",
                "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself",
                "just",
                "let's",
                "me", "more", "most", "mustn't", "my", "myself",
                "no", "nor", "not",
                "of", "off", "on", "once", "only", "or", "other", "ought", "our", "ours", "ourselves", "out", "over", "own",
                "same", "shan't", "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "some", "such",
                "than", "that", "that's", "the", "their", "theirs", "them", "themselves", "then", "there", "there's", "these",
                "they", "they'd", "they'll", "they're", "they've", "this", "those", "through", "to", "too", "under", "until",
                "up", "very",
                "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were", "weren't", "what", "what's", "when", "when's",
                "where", "where's", "which", "while", "who", "who's", "whom", "why", "why's", "with", "won't", "would",
                "wouldn't",
                "you", "you'd", "you'll", "you're", "you've", "your", "yours", "yourself", "yourselves",""));
        LinkedList<String> sentencesList = new LinkedList<>(Arrays.asList(s.toString().split("[.?]+")));
        HashMap <String, Integer> wordMap = new HashMap<>();
        LinkedHashMap <String, Integer> sentenceMap = new LinkedHashMap<>();
//        SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (String sentence : sentencesList) {
            for (String word : sentence.split("[, 0-9]+")) {
                if (stopWordsSet.contains(word.trim().toLowerCase())) {
                    continue;
                }
                wordMap.put(word, 0);
            }
        }
        try {
            if (!wordMap.isEmpty()) {


                for (String sentence : sentencesList) {
                    for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                        if (sentence.contains(entry.getKey())) {
                            wordMap.put(entry.getKey(), entry.getValue() + 1);
                        }
                    }
                }


//            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
//                System.out.printf("%s : %d\n",entry.getKey(),entry.getValue());
//            }


                for (String sentence : sentencesList) {
                    int frequency = 0;
                    for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                        if (sentence.contains(entry.getKey())) {
                            frequency += entry.getValue();
                        }
                    }
                    sentenceMap.put(sentence, frequency);
                }

                LinkedHashSet<Map.Entry<String, Integer>> set = new LinkedHashSet<>(sentenceMap.entrySet());

                System.out.println("Enter percentage : ");
                percentage = input.nextInt();

                if(percentage<=100 && percentage>=10) {
                    try {
                        for (int i = percentage; i > 0; i-=10) {
                            String pathTemp = "G:\\results\\data"+i+".txt";
                            File fileWriting = new File(pathTemp);
                            int j = 0;
                            total = (int) ((((double) i) / 100) * set.size());
                            fileWriting.createNewFile();
                            FileWriter fileWriter = new FileWriter(pathTemp);
                            BufferedWriter bw = new BufferedWriter(fileWriter);
                            while (total != 0) {
                                //System.out.printf("Sentence %d : %s\n", j, sortedSet.toArray()[j].toString().trim());
                                try {
                                    System.out.printf("Sentence %d : %s\n", j, set.toArray()[j].toString().trim());
                                    bw.write("Sentence "+ (j+1) +" : "+ set.toArray()[j].toString().trim().replaceAll("[=0-9]","").trim());
                                    bw.newLine();
                                    ++j;
                                    --total;
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            bw.close();
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input !!!");
                    }
                }
                else {
                    throw new SummaryExcpetion(ErrorCode.PERCENTATGEOUTOFRANGE);
                }
            } else {
                throw new SummaryExcpetion(ErrorCode.EMPTYWORDLIST);
            }
        }catch (SummaryExcpetion e){
            System.out.println(e.getMessage());
        }
    }
}