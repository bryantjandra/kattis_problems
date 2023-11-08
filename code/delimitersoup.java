
import java.util.*;
import java.io.*;

class delimitersoup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int L = Integer.parseInt(br.readLine());
        String line = br.readLine();
        Stack<Character> stck = new Stack<>();
        for (int i = 0; i < L; i++) {
            char ch = line.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stck.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stck.isEmpty() ||
                        ch == ')' && stck.peek() != '(' ||
                        ch == ']' && stck.peek() != '[' ||
                        ch == '}' && stck.peek() != '{') {
                    pw.println(ch + " " + i);
                    pw.close();
                    return;
                } else {
                    stck.pop();
                }
            }
        }
        pw.println("ok so far");
        pw.close();
    }
}
