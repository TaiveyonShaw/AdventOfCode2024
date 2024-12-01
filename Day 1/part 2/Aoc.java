import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;

public class Aoc {
    public static String[][] ReadFile() {
        String[][] FileArray = new String[1000][2];
        try {
            File myObj = new File("/home/taiveyonshaw/dev/AdventOfCode2024/Day 1/input");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
                FileArray[i] = myReader.nextLine().split("   ");
                i++;
            }
            myReader.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return FileArray;
    }

    public static int Solution(String[][] input) {
        int sum = 0;

        for (String[] x : input) {
            int count = 0;
            for (int j = 0; j < 1000; j++) {
                if (Integer.parseInt(x[0]) == Integer.parseInt(input[j][1])) {
                    count++;
                }
            }
            sum += count * Integer.parseInt(x[0]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Solution(ReadFile())); 
    }
}
