import java.util.*;
import java.io.*;

public class HashingFunctions {

    private static final int M = 10007; // Table size (a prime number is often a good choice for M)

    // String hashing function
    public static int hashString(String s) {
        int hashValue = 0;
        for (char c : s.toCharArray()) {
            hashValue = ((hashValue * 26) % M + (Character.toUpperCase(c) - 'A' + 1)) % M;
        }
        return hashValue;
    }

    // Division method for integers
    public static int hashInteger(int key) {
        return key % M;
    }

    public static void main(String[] args) {
        String testString = "HELLO";
        int testInt = 12345;

        System.out.println("Hash of string " + testString + ": " + hashString(testString));
        System.out.println("Hash of integer " + testInt + ": " + hashInteger(testInt));
    }
}
