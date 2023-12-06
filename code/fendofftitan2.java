import java.io.*;
import java.util.*;

class Jalanan implements Comparable<Jalanan> {
    int village, shamans, titans;
    long distance;

    public Jalanan(int village, long distance, int shamans, int titans) {
        this.village = village;
        this.distance = distance;
        this.shamans = shamans;
        this.titans = titans;
    }

    @Override
    public int compareTo(Jalanan other) {
        if (this.titans != other.titans) {
            return this.titans - other.titans;
        }
        if (this.shamans != other.shamans) {
            return this.shamans - other.shamans;
        }
        return Long.compare(this.distance, other.distance);
    }
}

public class FendOffTitan {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]) - 1;
        int y = Integer.parseInt(tokens[3]) - 1;

        ArrayList<int[]>[] AL = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            AL[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]) - 1;
            int b = Integer.parseInt(tokens[1]) - 1;
            int w = Integer.parseInt(tokens[2]);
            int c = Integer.parseInt(tokens[3]);
            AL[a].add(new int[] { b, w, c });
            AL[b].add(new int[] { a, w, c });
        }

        Map<String, Long> dist = new HashMap<>();
        PriorityQueue<Jalanan> pq = new PriorityQueue<>();
        pq.add(new Jalanan(x, 0, 0, 0));
        dist.put(x + ",0,0", 0L);

        while (!pq.isEmpty()) {
            Jalanan curr = pq.poll();
            if (curr.village == y) {
                pw.println(curr.distance + " " + curr.shamans + " " + curr.titans);
                pw.close();
                return;
            }

            for (int[] next : AL[curr.village]) {
                int nextVillage = next[0];
                long nextDist = curr.distance + next[1];
                int nextShamans = curr.shamans + (next[2] == 1 ? 1 : 0);
                int nextTitans = curr.titans + (next[2] == 2 ? 1 : 0);
                String nextState = nextVillage + "," + nextShamans + "," + nextTitans;

                if (!dist.containsKey(nextState) || nextDist < dist.get(nextState)) {
                    dist.put(nextState, nextDist);
                    pq.add(new Jalanan(nextVillage, nextDist, nextShamans, nextTitans));
                }
            }
        }

        pw.println("IMPOSSIBLE");
        pw.close();
    }
}
