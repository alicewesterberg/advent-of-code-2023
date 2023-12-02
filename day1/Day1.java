package day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Day1 {
    static Vector<Integer> p1;
    static Vector<Integer> p2;

    static List<String> nmbrlist = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    public static void main(String[] args) throws IOException {
        p1 = new Vector<>();
        p2 = new Vector<>();
        File myObj = new File("/Users/alicewesterberg/advent-of-code-2023/day1/input2.txt");
        File test = new File("/Users/alicewesterberg/advent-of-code-2023/day1/test.txt");
        List<String> fileContent = Files.readAllLines(myObj.toPath(), UTF_8);
        List<String> testfileContent = Files.readAllLines(test.toPath(), UTF_8);
        problem1(fileContent);

    }
//54627

    public static void problem1(List<String> list) {
        Vector<String> nmbrs = new Vector<>(nmbrlist);
        for (String s : list) {
            Vector<Character> p1_digits = new Vector<>();
            Vector<Character> p2_digits = new Vector<>();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    p1_digits.add(s.charAt(i));
                    p2_digits.add(s.charAt(i));
                }
                for (String sub: nmbrs) {
                    if (s.substring(i).startsWith(sub)){
                        p2_digits.add(Character.forDigit(nmbrs.indexOf(sub) + 1,10));
                    }
                }
            }
            // Check if p1_digits has at least two elements
            //String toAdd = p1_digits.get(0) + "" + p1_digits.lastElement();
            String toAdd2 = p2_digits.get(0) + "" + p2_digits.lastElement();

            //System.out.println("toAdd: " + toAdd);
            System.out.println("toAdd2: " + toAdd2);

            //p1.add(Integer.parseInt(toAdd));
            p2.add(Integer.parseInt(toAdd2));

        }
        System.out.println( p1.stream()
                .mapToInt(Integer::valueOf)
                .sum());

        System.out.println( p2.stream()
                .mapToInt(Integer::valueOf)
                .sum());
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