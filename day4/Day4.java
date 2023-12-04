package day4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Day4 {

    public static void main (String[] args) throws IOException {
        File myObj = new File("/Users/alicewesterberg/advent-of-code-2023/day4/input.txt");
        List<String> fileContent = Files.readAllLines(myObj.toPath(), UTF_8);
        ArrayList<Set<Integer>> winninglist = new ArrayList<>();
        ArrayList<Set<Integer>> mylist = new ArrayList<>();
        for (String s: fileContent){
            String str = s.split(":")[1].trim();
            String[] yourNums = str.split("\\|")[1].trim().split(" ");
            String[] winners = str.split("\\|")[0].trim().split(" ");
            Set<Integer> winningset = new HashSet<>();
            Set<Integer> myset = new HashSet<>();
            for (String s3: winners){
                if (!s3.equals("")) {
                    winningset.add(Integer.parseInt(s3));
                }
            }
            for (String s2: yourNums){
                if (!s2.equals("")) {
                    myset.add(Integer.parseInt(s2));
                }
            }
            winninglist.add(winningset);
            mylist.add(myset);
        }
        int n = 0;
        /*for (int i = 0; i < winninglist.size(); i++){
            winninglist.get(i).retainAll(mylist.get(i));
            int j = winninglist.get(i).size();
            n = n + (int)Math.pow(2,j-1);
        }
         */
        int[] freq = new int[winninglist.size()];
        for (int i = 0; i < mylist.size(); i++){
            freq[i] += 1; //plussa med vår lott
            int cards = freq[i]; //hämta antal lotter vi har
            winninglist.get(i).retainAll(mylist.get(i)); //intersection
            int j = winninglist.get(i).size();
            for (int k = 1; k<=j; k++){
                freq[i+k] += freq[i];
            }

        }
        int sum = 0;
        for (int i = 0; i < freq.length; i++)
            sum += freq[i];
        System.out.println(sum);
        System.out.println(n);
    }
}
