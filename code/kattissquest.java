
import java.util.*;
import java.io.*;

class Quest {
    int energy, gold;

    public Quest(int energy, int gold) {
        this.energy = energy;
        this.gold = gold;
    }
}

class kattissquest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, PriorityQueue<Quest>> map = new TreeMap<>();
        Comparator<Quest> sortPQ = new Comparator<Quest>() {
            public int compare(Quest x, Quest y) {
                return y.gold - x.gold; // "if tied, by the largest gold reward"
            }
        };

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            String command = tokens[0];
            if (command.equals("add")) {
                int E = Integer.parseInt(tokens[1]);
                int G = Integer.parseInt(tokens[2]);
                Quest quest = new Quest(E, G);
                PriorityQueue<Quest> pq = map.getOrDefault(E, new PriorityQueue<>(sortPQ));
                pq.add(quest);
                map.put(E, pq);
            } else if (command.equals("query")) {
                long totalGold = 0;
                int X = Integer.parseInt(tokens[1]);
                while (X > 0) {
                    Map.Entry<Integer, PriorityQueue<Quest>> x = map.floorEntry(X);
                    if (x == null) { // because surely there will reach a point where there is no element that is
                                     // smaller than it...
                        break;
                    }
                    Quest quest = x.getValue().poll();
                    if (x.getValue().isEmpty()) {
                        map.remove(x.getKey());
                    }
                    X -= quest.energy;
                    totalGold += quest.gold;
                }
                pw.println(totalGold);
                pw.flush();
            }
        }
        pw.close();
    }
}
