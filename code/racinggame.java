
//turn on screen recording, this is a close internet PE
import java.util.*;
import java.io.*;

class racinggame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int Q = Integer.parseInt(br.readLine());

        Comparator<Integer> sortPQ = new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        };

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < Q; i++) {
            String[] tokens = br.readLine().split(" ");
            int command = Integer.parseInt(tokens[0]);
            if (command == 1) {
                int X = Integer.parseInt(tokens[1]);
                // PriorityQueue<Integer> pq = map.getOrDefault(X, new PriorityQueue<>(sortPQ));
                // pq.add(X);
                // map.put(X, pq);
                map.put(X, X);
            } else if (command == 2) {
                int Y = Integer.parseInt(tokens[1]);
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    map.put(entry.getKey(), map.get(entry.getKey()) + Y);
                }
            } else if (command == 3) {
                int Z = Integer.parseInt(tokens[1]);
                Map.Entry<Integer, Integer> maxEntry = map.lastEntry();
                while (Z-- > 0) {
                    Map.Entry<Integer, Integer> successor = map.lowerEntry(maxEntry.getKey());
                    if (successor == null) {
                        break;
                    }
                    maxEntry = successor;
                }
                pw.println(maxEntry.getValue());

            }
        }
        pw.close();
    }
}
