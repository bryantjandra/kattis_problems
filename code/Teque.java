import java.util.*;
import java.io.*;

class Teque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> front = new HashMap<>();
        HashMap<Integer, Integer> back = new HashMap<>();
        int frontHead = -1;
        int backHead = -1;
        int frontTail = 0;
        int backTail = 0;

        while (n-- > 0) {
            String[] tokens = br.readLine().split(" ");
            String command = tokens[0];
            int x = Integer.parseInt(tokens[1]);
            if (command.equals("push_back")) {
                back.put(backTail, x);
                backTail++;
            } else if (command.equals("push_front")) {
                front.put(frontHead, x);
                frontHead--;
            } else if (command.equals("push_middle")) {
                front.put(frontTail, x);
                frontTail++;
            } else {
                if (x < front.size()) {
                    pw.println(front.get(x + frontHead + 1));
                } else {
                    pw.println(back.get(x - front.size() + backHead + 1));
                }
            }
            if (front.size() < back.size()) {
                front.put(frontTail, back.get(backHead + 1));
                frontTail++;
                back.remove(++backHead);
            } else if (front.size() - 1 > back.size()) {
                back.put(backHead, front.get(frontTail - 1));
                backHead--;
                front.remove(--frontTail);
            }
        }
        pw.flush();
    }
}