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
        List <Map<Long, Long>> listofthings = new ArrayList<>();
        listofthings.add(seedtosoil);
        listofthings.add(soiltofert);
        listofthings.add(ferttowater);
        listofthings.add(watertolight);
        listofthings.add(lighttotemp);
        listofthings.add(temptohumidity);
        listofthings.add(humtoloc);
        Long seedNumber;
        for (String s: seeds){
            seedtosoil.put(Long.parseLong(s),(long) 0);
        }
        for (String str: fileContent){
            String s = str.split(":")[0];
            //System.out.println(s);
            if (s.isEmpty()){
                index++;
            } else if (Character.isDigit(s.charAt(0))){
                String[] number = s.split(" ");
                for(String seed: seeds) {
                    seedNumber = Long.parseLong(seed);
                    if (index != 0){
                        for (int i = 0; i< index; i++){
                            seedNumber = listofthings.get(i).get(seedNumber);
                            System.out.println(seedNumber + " " + index);

                        }
                    }
                    Long seedInterval1 = Math.min(Long.parseLong(number[0]), Long.parseLong(number[1]));
                    Long seedInterval2 = Math.max(Long.parseLong(number[0]),Long.parseLong(number[1]));
                    if(seedNumber <= seedInterval2 && seedNumber >= seedInterval1){
                        listofthings.get(index).put(seedNumber,seedNumber+Long.parseLong(number[2]));
                    }


                }

            }
        //System.out.println(humtoloc);
        }



    }
}


