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
        File myObj2 = new File("/Users/alicewesterberg/advent-of-code-2023/day2/input2.txt");
        List<String> fileContent = Files.readAllLines(myObj.toPath(), UTF_8);
        List<String> fileContent2 = Files.readAllLines(myObj2.toPath(), UTF_8);
        problem(fileContent2);


    }
    public static void problem(List<String> list) {
        int tooMany = 0; // counts how many that workds
        int index = 0; // which game
        int powersets = 0; //sum of powersets
        for (String s : list) {
            int reds = 0; // max reds
            int blues = 0; // max blues
            int greens = 0; // max greens
            index++; // index one up
            boolean doesntWork = false; // doesn't work standard false
            String[] str = s.split(":"); // delar upp från game 1
            String[] s0 = str[1].split(";"); // delar upp ;
            for (int i = 0; i < s0.length; i++) { //för varje mellan ;
                int nmbrofRed = 0; // number total red for each pull
                int nbmrofGreen = 0;// number total red for each pull
                int nmbrofBlue = 0;// number total red for each pull
                String[] s1 = s0[i].split(","); // splittar ,
                for (int j = 0; j < s1.length; j++) { // för vare mellan ,
                    String[] argument = s1[j].split(" "); // splittar mellanslag
                    int number = Integer.parseInt((argument[1]));// tar första siffran
                    String command = argument[2];// tar första command
                    switch (command) {
                        case "red" :
                            if (reds<number) {
                                reds = number;
                            }
                            nmbrofRed = number;
                            break;
                        case "green":
                            if (greens<number) {
                                greens = number;
                            }
                            nbmrofGreen = number;
                            break;
                        case "blue":
                            if (blues<number) {
                                blues = number;
                            }
                            nmbrofBlue = number;
                            break;
                        default:
                            System.out.println("Command not found");
                            break;
                    }
                }
                if ((nmbrofRed <= 12 && nmbrofBlue <= 14 &&  nbmrofGreen <= 13) && !(doesntWork)){
                }
                else {
                   doesntWork = true;
                }

            }
            if (!doesntWork) {
                tooMany += index;
            }
            powersets += reds*blues*greens;
        }
        System.out.println(tooMany);
        System.out.println(powersets);

    }
    }
