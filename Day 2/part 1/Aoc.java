import java.io.*;
import java.util.*;

public class Aoc {
    public static ArrayList<String[]> ReadFile() {
        ArrayList<String[]> FileArray = new ArrayList<String[]>();
        try {
            File myObj = new File("/home/taiveyonshaw/dev/AdventOfCode2024/Day 2/input");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                FileArray.add(myReader.nextLine().split(" "));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return FileArray;
    }

    public static Integer Solution(ArrayList<String[]> input) {
        int safeCount = 1000;
        for (String[] i : input) {
            boolean decreasing = false;
            if (Integer.parseInt(i[0]) > Integer.parseInt(i[1])) {
                decreasing = true;
            }
            for (int j = 1; j < i.length; j++) {
                int difference = Integer.parseInt(i[j - 1]) - Integer.parseInt(i[j]);
                if (decreasing && (difference < 1 || difference > 3)) {
                    safeCount--;
                    break;
                } else if (!decreasing && (difference < -3 || difference > -1)) {
                    safeCount--;
                    break;
                }
            }
        }
        return safeCount;
    }

    public static void main(String[] args) {
        System.out.println(Solution(ReadFile()));
    }
}