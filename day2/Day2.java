package day2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;
//  12 red cubes, 13 green cubes, and 14 blue cubes?
public class Day2 {

    public static void main(String[] args) throws IOException {
        File myObj = new File("/Users/alicewesterberg/advent-of-code-2023/day2/input.txt");
        List<String> fileContent = Files.readAllLines(myObj.toPath(), UTF_8);
        problem(fileContent);


    }
    public static void problem(List<String> list) {
        int tooMany = 0;
        int index = 0;
        for (String s : list) {
            index++;
            boolean doesntWork = false;
            String[] str = s.split(":"); // delar upp från game 1
            String[] s0 = str[1].split(";"); // delar upp ;
            System.out.println(str[1]);  // printar hela raden för olika games
            for (int i = 0; i < s0.length; i++) { //för varje mellan ;
                int nmbrofRed = 0;
                int nbmrofGreen = 0;
                int nmbrofBlue = 0;
                System.out.println(s0[i]); // printar varje ;
                String[] s1 = s0[i].split(","); // splittar ,
                for (int j = 0; j < s1.length; j++) { // för vare mellan ,
                    String[] argument = s1[j].split(" "); // splittar mellanslag
                    int number = Integer.parseInt((argument[1]));// tar första siffran
                    System.out.println(number);
                    String command = argument[2];// tar första command
                    switch (command) {
                        case "red" -> nmbrofRed += number;
                        case "green" -> nbmrofGreen += number;
                        case "blue" -> nmbrofBlue += number;
                        default -> System.out.println("Command not found");
                    }
                }
                System.out.println("REDS: "+ nmbrofRed);
                System.out.println("GREEN: "+ nbmrofGreen);
                System.out.println("BLUE: "+ nmbrofBlue);
                if ((nmbrofRed <= 12 && nmbrofBlue <= 14 &&  nbmrofGreen <= 13) && !(doesntWork)){
                    System.out.println("i: "+ index);
                }
                else {
                   doesntWork = true;
                }
            }
            if (!doesntWork) {
                tooMany += index;
            }
        }
        System.out.println(tooMany);

    }
    }
