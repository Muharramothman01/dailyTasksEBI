import java.io.*;
import java.util.*;

public class FileDealer {
    public static File createFile(String path) throws IOException {
        File file =new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        return file;
    }
    public static String createDir(String path){
        File file =new File(path);
        if(!file.exists()){
            file.mkdirs();
            System.out.println("Directory is created successfully");
        }else{
            System.out.println("Directory is already exists");
        }
        return file.getAbsolutePath();
    }

    public static String fileRead(String path) throws IOException  {
        FileReader f = new FileReader(path);
        BufferedReader br =new BufferedReader(f);
        String content = "";
        String line;
        while(true){
           if ((line = br.readLine()) !=null) {
               content += line;
           }
           else {
               break;
           }
        }
        return content;
    }

    public static void fileWrite(LinkedHashSet<String> set, SortedSet<Map.Entry<String, Integer>> sortedSet, String path, int percentage, int total) throws IOException{
        System.out.println(sortedSet.size());
        System.out.println(set.size());
        ArrayList<String> unsorted = new ArrayList<>();
        ArrayList<String> sorted = new ArrayList<>();
        for (int i1 = 0; i1 < sortedSet.toArray().length; i1++) {
            sorted.add(sortedSet.toArray()[i1].toString().replaceAll("[=0-9]","").trim());
        }

        for (int i1 = 0; i1 < set.toArray().length; i1++) {
            unsorted.add(set.toArray()[i1].toString().replaceAll("[=0-9]","").trim());
        }

        ArrayList<Integer> indexes = new ArrayList<>();

        System.out.println(sorted.size());
        System.out.println(unsorted.size());
        for (String s : sorted) {
            System.out.println(s);
            indexes.add(unsorted.indexOf(s));
        }

        Collections.sort(indexes);
        System.out.println(indexes);

        for (int i =percentage; i>0;i-=10) {
            String newFlie=path+i+"data.txt";
            File file = FileDealer.createFile(newFlie);
            FileWriter f =new FileWriter(newFlie);
            BufferedWriter bw =new BufferedWriter(f);
            int count = 0;
            total = (int) ((((double) i) / 100) * unsorted.size()-1);
//            System.out.println(unsorted.size());

            if (isFileEmpty(file)){
                bw.write("Summarization with "+i+"% percent");
                bw.newLine();
                bw.newLine();
                bw.newLine();
            }

            for (int i1 = 0; i1 < total; i1++) {
                if (i1==indexes.size())break;
                bw.write(++count+" - Statement : "+unsorted.get(indexes.get(i1)));
                bw.newLine();
            }
            bw.close();
        }

    }

    public static boolean isFileEmpty(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException("Cannot check the file length. The file is not found: " + file.getAbsolutePath());
        }
        return file.length() == 0;
    }
}
