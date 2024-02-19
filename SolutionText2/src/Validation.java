import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;


public class Validation {
    public static void validPercentage(LinkedHashSet<String> set, SortedSet<Map.Entry<String, Integer>> sortedSet, String path) throws SummeriesException{
        int percentage = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter percentage to summarize");
            System.out.println("please enter percentage greater than 10%");
            percentage = scanner.nextInt();
            if(percentage < 10) {
                throw new SummeriesException(ErrorCode.PERCENTATGEOUTOFRANGE);
            }


        if (percentage <= 100) {
            int total = (int) ((((double) percentage) / 100) * set.size());
            if(total != 0) {
                    try {
                        FileDealer.fileWrite(set,sortedSet,path,percentage,total);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            } else {
                throw new SummeriesException(ErrorCode.PERCENTATGEOUTOFRANGE);
            }
        } else {
            throw new SummeriesException(ErrorCode.PERCENTATGEOUTOFRANGE);
        }
    }
}