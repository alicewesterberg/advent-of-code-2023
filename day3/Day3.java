package day3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Day3 {

    static String[][] matrix;

    public static void main(String[] args) throws IOException {
        File myObj = new File("/Users/alicewesterberg/advent-of-code-2023/day3/input.txt");
        List<String> fileContent = Files.readAllLines(myObj.toPath(), UTF_8);
        matrix = new String[fileContent.size()][fileContent.get(0).length()];
        for (int i = 0; i < fileContent.size(); i++) {
            for (int j = 0; j < fileContent.get(i).length(); j++) {
                matrix[i][j] = fileContent.get(i).charAt(j) + "";
            }
        }
        int R = matrix.length;
        int C = matrix[0].length;


        int res1 = 0;
        int res2 = 0;
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for (int r = 0; r < R; r++) { //for all rows
            int n = 0; // the number to add
            boolean exist = false; // check if it should calculate
            String coordinates = "";

            for (int c = 0; c <= C; c++) { //for all columns
                if (c < C && Character.isDigit(matrix[r][c].charAt(0))) { // test if c is within C and not the end and is digit
                    n = n * 10 + Character.getNumericValue(matrix[r][c].charAt(0)); //add to n according left to right
                    for (int rr = -1; rr <= 1; rr++) { // for (rows) 1 before and after
                        for (int cc = -1; cc <= 1; cc++) { // for colums one before and after
                            //checking every one around for special characters
                            if (0 <= r + rr && r + rr < R && 0 <= c + cc && c + cc < C) { // check that it is within dimensions
                                char ch = matrix[r + rr][c + cc].charAt(0); // get char before, and after
                                if (!Character.isDigit(ch) && ch != '.') { // if it's not digit and not .
                                    exist = true; //if special character exist = true
                                }
                                if (ch == '*') {
                                    coordinates = (r + rr) + "," + (c + cc);
                                }
                            }
                        }
                    }
                } else if (n > 0) {
                    map.computeIfAbsent(coordinates, k -> new ArrayList<>()).add(n);

                    if (exist) { // if exist
                        res1 += n; //add n to res1
                    }

                    n = 0; // reset everything
                    exist = false;
                    coordinates = "";


                }
            }

        }
        System.out.println(res1);
        for (List<Integer> values : map.values()) {
            if (values.size() == 2) {
                res2 += values.get(0) * values.get(1);
            }
        }
        System.out.println(res2);


//Character.isDigit(matrix[row][cols].charAt(0))

    }
}
