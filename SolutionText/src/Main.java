import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        long start = System.nanoTime();
        String s = "I am going to hire professional help tomorrow. I can not handle this anymore. She fell over the coffee table and now there is blood in her catheter. This is much more than I ever signed up to do.The red line moved across the page. With each millimeter it advanced forward, something changed in the room. The actual change taking place was difficult to perceive, but the change was real. The red line continued relentlessly across the page and the room would never be the same.";
        String[] stopWords = {
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
                "you", "you'd", "you'll", "you're", "you've", "your", "yours", "yourself", "yourselves"
        };
        String[] sentences = s.split("\\. +");
        HashSet <String> stopWordsSet = new HashSet<>(Arrays.asList(stopWords));
        LinkedList<String> sentencesList = new LinkedList<>();
        HashMap <String, Integer> wordMap = new HashMap<>();
        LinkedHashMap <String, Integer> sentenceMap = new LinkedHashMap<>();
        String[] words;
        int maximum = 0;

        for (String sentence : sentences) {
            sentencesList.add(sentence.replace(".",""));
        }

        for (String sentence : sentencesList) {
            words = sentence.split(" ");
            for (String word : words) {
                if (stopWordsSet.contains(word.toLowerCase())) {
                    continue;
                }
                wordMap.put(word, 0);
            }
        }

        for (String sentence : sentencesList) {
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                if(sentence.contains(entry.getKey())){
                    wordMap.put(entry.getKey(),entry.getValue()+1);
                }
            }
        }


//        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
//            System.out.printf("%s : %d\n",entry.getKey(),entry.getValue());
//        }

        for (String sentence : sentencesList) {
            int frequency = 0;
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                if(sentence.contains(entry.getKey())){
                    frequency+=entry.getValue();
                }
            }
            maximum+=frequency;
            sentenceMap.put(sentence,frequency);
        }

        System.out.printf("The most Sentence weight is : \"%s\" with %d%% of the whole sentences \n",Collections.max(sentenceMap.entrySet(), Map.Entry.comparingByValue()).getKey(),(Collections.max(sentenceMap.entrySet(), Map.Entry.comparingByValue()).getValue() * 100)/maximum);
        long end = System.nanoTime();
        System.out.println((end - start) / 100);
    }
}