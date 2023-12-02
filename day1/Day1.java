package day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Day1 {
    static int firstindex = 0;
    static int secondindex = 0;

    static List<String> nmbrlist = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    public static void main(String[] args) throws IOException {
        File myObj = new File("/Users/alicewesterberg/advent-of-code-2023/day1/input2.txt");
        File test = new File("/Users/alicewesterberg/advent-of-code-2023/day1/test.txt");
        List<String> fileContent = Files.readAllLines(myObj.toPath(), UTF_8);
        List<String> testfileContent = Files.readAllLines(test.toPath(), UTF_8);
        System.out.print(problem2(fileContent));

    }
//54627

    public static int problem1(List<String> list) {
        Vector<Integer> numbers = new Vector<>();
        int firstnumber = 0;
        int secondnumber = 0;
        boolean firstfound = false;
        boolean secondfound = false;
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i)) && (!firstfound)) {
                    firstnumber = Character.getNumericValue(s.charAt(i));
                    firstfound = !firstfound;
                    firstindex = i;



                }
                char ch = s.charAt(s.length() - 1 - i);
                if (Character.isDigit(ch) && (!secondfound)) {
                    secondnumber = Character.getNumericValue(ch);
                    secondfound = !secondfound;
                    secondindex = s.length() - 1 - i;

                }
            }
            numbers.add((firstnumber * 10 + secondnumber));
            firstfound = false;
            secondfound = false;
            firstnumber = 0;
            secondnumber = 0;

        }

        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .sum();


    }

    public static int problem2(List<String> list) {
        Vector<Integer> numbers = new Vector<>();
        int firstnumber = 0;
        int secondnumber = 0;
        boolean firstfound = false;
        boolean secondfound = false;
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i)) && (!firstfound)) {
                    firstnumber = Character.getNumericValue(s.charAt(i));
                    firstfound = true;
                    firstindex = i;
                    if (findlowernumbers(s, firstindex) != -1){
                        firstnumber = findlowernumbers(s, firstindex);
                    }
                    


                }
                char ch = s.charAt(s.length() - 1 - i);
                if (Character.isDigit(ch) && (!secondfound)) {
                    secondnumber = Character.getNumericValue(ch);
                    secondfound = true;
                    secondindex = s.length() - 1 - i;
                    if (findhighernumbers(s, secondindex) != -1){
                        secondnumber = findhighernumbers(s, secondindex);
                    }

                }
            }
            numbers.add((firstnumber * 10 + secondnumber));
            System.out.println((firstnumber * 10 + secondnumber) + " " + s + " " + numbers.stream()
                    .mapToInt(Integer::valueOf)
                    .sum());
            firstfound = false;
            secondfound = false;
            firstnumber = 0;
            secondnumber = 0;

        
        }

        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .sum();

                
            
            
        }



        public static int findlowernumbers(String s, int place){
            Vector<String> nmbrs = new Vector<String>(nmbrlist);
            int res = -1;
            int resind = 9;
            for (int index = 0; index < 9; index++) {
                int i = s.indexOf(nmbrs.get(index));
                if (i < place && !(i < 0) && i < resind) {
                    res = convert(s.substring(i, i+nmbrs.get(index).length()));
                    resind = i;
                }
            }
            return res;
        }

        public static int findhighernumbers(String s, int place){
            Vector<String> nmbrs = new Vector<String>(nmbrlist);
            int res =-1;
            int resind = 0;
            for (int index = 0; index < 9; index++) {
                int i = s.lastIndexOf(nmbrs.get(index));
                if (i > place && !(i < 0) && i > resind) {
                    res = convert(s.substring(i, i+nmbrs.get(index).length()));
                    resind = i;

                }
            }
            return res;
        }

    


        public static int convert (String s){
            return switch (s) {
                case "one" -> 1;
                case "two" -> 2;
                case "three" -> 3;
                case "four" -> 4;
                case "five" -> 5;
                case "six" -> 6;
                case "seven" -> 7;
                case "eight" -> 8;
                case "nine" -> 9;
                default -> 0;
            };
        }


    }




