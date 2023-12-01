package day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Day1 {

    public static void main(String[] args) throws IOException {
        File myObj = new File("/Users/alicewesterberg/advent-of-code-2023/day1/input.txt");
        List<String> fileContent = Files.readAllLines(myObj.toPath(), UTF_8);
        System.out.print(problem1(fileContent));

    }

    

    public static int problem1(List<String> list){
       Vector<Integer> numbers = new Vector<>();
        int firstnumber = 0;
        int secondnumber = 0;
        boolean firstfound = false;
        boolean secondfound = false;
        for (String s: list){
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i)) && (!firstfound)) {
                    firstnumber = Character.getNumericValue(s.charAt(i));
                    firstfound = !firstfound;
                }
                char ch = s.charAt(s.length() - 1 - i);
                if (Character.isDigit(ch) && (!secondfound)) {
                    secondnumber = Character.getNumericValue(ch);
                    secondfound = !secondfound;
                }
            }
            numbers.add((firstnumber*10 + secondnumber));
            firstfound = false;
            secondfound = false;
            firstnumber = 0;
            secondnumber = 0;

        }

        return  numbers.stream()
                .mapToInt(Integer::valueOf)
                .sum();


    }

    
}
