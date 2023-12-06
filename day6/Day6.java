package day6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Day6 {

    public static void main(String[] args) throws IOException {
        File myObj = new File("/Users/alicewesterberg/advent-of-code-2023/day6/input.txt");
        List<String> fileContent = Files.readAllLines(myObj.toPath(), UTF_8);
        ArrayList<String> al = new ArrayList<>();
        String[] onerace = new String[2];
        int index = 0;
        for (String s: fileContent){
            StringBuilder stringeling = new StringBuilder();
            String[] str = s.split(":")[1].trim().split(" ");
            for (String stri : str){
                if (!stri.isEmpty()){
                    stringeling.append(stri);
                    al.add(stri);
                }
            }
            onerace[index] = stringeling.toString();
            System.out.println(onerace[index]);
            index++;

        }
        int totally = 1;
        for (int i = 0; i < 4; i++){
            int totalwins = 0;
            int totaltime = Integer.parseInt(al.get(i));
            int record = Integer.parseInt(al.get(4+i));
            for (int j = 0; j<= totaltime; j++){
                if ((totaltime-j) * j > record){
                    totalwins += 1;
                }
            }
            totally *= totalwins;
        }
        int totalone = 0;
        for (int j = 0; j<= Long.parseLong(onerace[0]); j++){
            if ((Long.parseLong(onerace[0])-j) * j > Long.parseLong(onerace[1])){
                totalone += 1;
            }
        }
        System.out.println(totally);
        System.out.println(totalone);
    }
}
