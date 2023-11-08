import java.util.*;
import java.io.*;

class heirsdilemma {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int h = sc.nextInt();
        int counter = 0;
        for (int i = l; i < h; i++) {
            if (isValid(i)) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    // 1. convert integer to a String
    // 2. convert string to array of characters
    // 3. convert character to integer
    // 4. check index of first occurence and index of last occurence same or not.

    public static boolean isValid(int i) {
        String num = String.valueOf(i);
        for (char ch : num.toCharArray()) {
            int each = Character.getNumericValue(ch);
            if (each == 0 || i % each != 0 || num.indexOf(ch) != num.lastIndexOf(ch)) {
                return false;
            }
        }
        return true;
    }
}
