package day5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Day5 {

    public static void main (String[] args) throws IOException {
        File myObj = new File("/Users/alicewesterberg/advent-of-code-2023/day5/input.txt");
        List<String> fileContent = Files.readAllLines(myObj.toPath(), UTF_8);
        String[] seeds = fileContent.get(0).split(":")[1].trim().split(" ");
        Map<Long, Long> seedtosoil = new HashMap<>();
        Map<Long, Long> soiltofert = new HashMap<>();
        Map<Long, Long> ferttowater = new HashMap<>();
        Map<Long, Long> watertolight = new HashMap<>();
        Map<Long, Long> lighttotemp = new HashMap<>();
        Map<Long, Long> temptohumidity = new HashMap<>();
        Map<Long, Long> humtoloc = new HashMap<>();
        int index = -1;
        List<Map<Long, Long>> listofthings = Arrays.asList(
                seedtosoil, soiltofert, ferttowater,
                watertolight, lighttotemp, temptohumidity, humtoloc
        );
        Long current;
        for (String s: seeds){
            seedtosoil.put(Long.parseLong(s),Long.parseLong(s));
        }
        int antal = 0;
        for (String str: fileContent){
            String s = str.split(":")[0];
            if (s.isEmpty()){
                index++;
            } else if (Character.isDigit(s.charAt(0))){
                String[] number = s.split(" ");
                antal++;
                for(String seed: seeds) {
                    current = Long.parseLong(seed);
                    for (int i = 0; i< index; i++){
                        current = listofthings.get(i).get(current);

                    }


                    Long seedInterval1 = Long.parseLong(number[1]);
                    Long seedInterval2 = Long.parseLong(number[1]) + Long.parseLong(number[2]);
                    if(current != null && current < seedInterval2 && current >= seedInterval1){
                        listofthings.get(index).put(current,current+Long.parseLong(number[0]) - seedInterval1 );
                        System.out.println("i: "+ index + " current: "+ current + " put: " + (current+Long.parseLong(number[0]) - seedInterval1));
                    } else {
                        if (!listofthings.get(index).containsKey(current)) {
                            listofthings.get(index).put(current, current);

                        }
                    }
                }

            }
        }
        Long min = Long.MAX_VALUE;
        for (long value: humtoloc.values()){
            //System.out.println(value);
            if (value < min){
                min = value;

            }
        }
        System.out.println(min);

    }
}


