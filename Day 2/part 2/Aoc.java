import java.io.*;
import java.util.*;

public class Aoc {
    public static ArrayList<String[]> ReadFile() {
        ArrayList<String[]> FileArray = new ArrayList<String[]>();
        try {
            File myObj = new File("../input");
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
        int safeCount = 0;
        
        for (String[] strSeq : input) {
            // Convert string array to int array
            int[] sequence = new int[strSeq.length];
            for (int i = 0; i < strSeq.length; i++) {
                sequence[i] = Integer.parseInt(strSeq[i]);
            }
            
            // Check if sequence is safe (either already valid or valid after removing one number)
            if (isValidSequence(sequence) || canBeMadeValid(sequence)) {
                safeCount++;
            }
        }
        return safeCount;
    }
    
    private static boolean isValidSequence(int[] sequence) {
        boolean increasing = true;
        boolean decreasing = true;
        
        for (int i = 1; i < sequence.length; i++) {
            int diff = sequence[i] - sequence[i-1];
            if (diff > 0) decreasing = false;
            if (diff < 0) increasing = false;
            if (Math.abs(diff) > 3 || diff == 0) {
                return false;
            }
        }
        return increasing || decreasing;
    }
    
    private static boolean canBeMadeValid(int[] sequence) {
        // Try removing each number
        for (int skip = 0; skip < sequence.length; skip++) {
            boolean increasing = true;
            boolean decreasing = true;
            int prev = -1;
            
            for (int i = 0; i < sequence.length; i++) {
                if (i == skip) continue;
                
                if (prev != -1) {
                    int diff = sequence[i] - prev;
                    if (diff > 0) decreasing = false;
                    if (diff < 0) increasing = false;
                    if (Math.abs(diff) > 3 || diff == 0) {
                        increasing = false;
                        decreasing = false;
                        break;
                    }
                }
                prev = sequence[i];
            }
            
            if (increasing || decreasing) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Solution(ReadFile()));
    }
}
