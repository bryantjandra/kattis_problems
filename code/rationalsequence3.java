
import java.util.*;
import java.io.*;

class rationalsequence3 {
    public static int p(int i) {
        return i >> 1;
    }

    public static int l(int i) {
        return i << 1;
    }

    public static int r(int i) {
        return i << 1 + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int p = Integer.parseInt(br.readLine());
        while (p-- > 0) {
            String[] tokens = br.readLine().split(" ");
            int k = Integer.parseInt(tokens[0]);
            int n = Integer.parseInt(tokens[1]);
            Stack<String> stack = new Stack<>();
            while (n > 1) {
                if (l(p(n)) == n) {
                    stack.push("LEFT");
                } else {
                    stack.push("RIGHT");
                }
                n = p(n);
            }
            int numerator = 1;
            int denominator = 1;
            while (!stack.isEmpty()) {
                if (stack.peek() == "LEFT") {
                    denominator += numerator;
                } else {
                    numerator += denominator;
                }
                stack.pop();
            }
            pw.println(k + " " + numerator + "/" + denominator);
            pw.flush();
        }
        pw.close();
    }
}
