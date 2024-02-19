import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int total;
        int percentage;

        //String s = "132132123 asas .123It was a good idea. At least, they all thought it was a good idea at the time. Hindsight would reveal that in reality, it was an unbelievably terrible idea, but it would take another week for them to understand that. Right now, at this very moment. they all agreed that it was the perfect course of action for the current situation. It was a concerning development that he couldn't get out of his mind. He'd had many friends throughout his early years and had fond memories of playing with them, but he couldn't understand how it had all stopped. There was some point as he grew up that he played with each of his friends for the very last time, and he had no idea that it would be the last. Eating raw fish didn't sound like a good idea. It's a delicacy in Japan, didn't seem to make it any more appetizing. Raw fish is raw fish, delicacy or not. Why do Americans have so many different types of towels? We have beach towels, hand towels, bath towels, dish towels, camping towels, quick-dry towels, and let’s not forget paper towels. Would 1 type of towel work for each of these things? Let’s take a beach towel. It can be used to dry your hands and body with no difficulty. A beach towel could be used to dry dishes. Just think how many dishes you could dry with one beach towel. I’ve used a beach towel with no adverse effects while camping. If you buy a thin beach towel it can dry quickly too. I’d probably cut up a beach towel to wipe down counters or for cleaning other items, but a full beach towel could be used too. Is having so many types of towels an extravagant luxury that Americans enjoy or is it necessary? I’d say it's overkill, and we could cut down on the many types of towels that manufacturers deem necessary.";
        //String s = "It was a good idea. At least, least they all thought it was a good idea at the time.";
        //String s = "  123  ";
        //String s = "and or";
        String s = "";
        File file;

        System.out.println("Enter path of source : ");
        String path = input.nextLine().replace("\\","\\\\");
        try {
            if(path.trim().equals("")){
                throw new SummeriesException(ErrorCode.EMPTYPATH);
            }
            else {
               file = FileDealer.createFile(path);
               s = FileDealer.fileRead(path);
               //FileDealer.createDir(pathResult);
            }
            if(s.replaceAll("[ 0-9]+","").equals("")){
                throw new SummeriesException(ErrorCode.EMPTYSTRING);
            }
        } catch (SummeriesException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        LinkedList<String> sentencesList = new LinkedList<>(Arrays.asList(s.split("[.:?0-9]+")));
        HashMap <String, Integer> wordMap = new HashMap<>();
        LinkedHashMap <String, Integer> sentenceMap = new LinkedHashMap<>();
        SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (String sentence : sentencesList) {
            for (String word : sentence.split("[ ,0-9]+")) {
                if (stopWordsSet.contains(word.toLowerCase().trim())) {
                    continue;
                }
                wordMap.put(word, 0);
            }
        }


            if (!wordMap.isEmpty()) {

                for (String sentence : sentencesList) {
                    for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                        if(sentence.contains(entry.getKey())){
                            wordMap.put(entry.getKey(),entry.getValue()+1);
                        }
                    }
                }


//                for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
//                    System.out.printf("%s : %d\n",entry.getKey(),entry.getValue());
//                }

                for (String sentence : sentencesList) {
                    int frequency = 0;
                    for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                        if(sentence.contains(entry.getKey())){
                            frequency+=entry.getValue();
                        }
                    }
                    sentenceMap.put(sentence,frequency);
                }

                LinkedHashSet<String> set = new LinkedHashSet<>(sentenceMap.keySet());
                sortedSet.addAll(sentenceMap.entrySet());

                try {
                    Validation.validPercentage(set,sortedSet,"D:\\results\\");
                }catch (SummeriesException e){
                    System.out.println(e.getMessage());
                }
            }


    }
}