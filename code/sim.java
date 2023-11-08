
import java.util.*;
import java.io.*;

class sim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String line = br.readLine();
            LinkedList<Character> ll = new LinkedList<>();
            ListIterator<Character> pointer = ll.listIterator();
            for (char ch : line.toCharArray()) {
                if (ch == '[') {
                    pointer = ll.listIterator();
                } else if (ch == ']') {
                    pointer = ll.listIterator(ll.size());
                } else if (ch == '<') {
                    if (pointer.hasPrevious()) {
                        pointer.previous();
                        pointer.remove();
                    }
                } else {
                    pointer.add(ch);
                }
            }
            for (char z : ll) {
                pw.print(z);
            }
            pw.println();
        }
    }
}
