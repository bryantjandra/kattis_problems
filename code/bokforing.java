
import java.util.*;
import java.io.*;

class bokforing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int Q = Integer.parseInt(tokens[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        int resetVal = 0;
        while (Q-- > 0) {
            tokens = br.readLine().split(" ");
            String command = tokens[0];
            if (command.equals("SET")) {
                int i = Integer.parseInt(tokens[1]);
                int x = Integer.parseInt(tokens[2]);
                map.put(i, x);
            } else if (command.equals("RESTART")) {
                int x = Integer.parseInt(tokens[1]);
                map.clear();
                resetVal = x;

            } else {
                int i = Integer.parseInt(tokens[1]);
                pw.println(map.getOrDefault(i, resetVal));
                pw.flush();
            }
        }
    }
}
