
import java.util.*;
import java.io.*;

class Coworker {
    int annoyance, rate;

    public Coworker(int annoyance, int rate) {
        this.annoyance = annoyance;
        this.rate = rate;
    }
}

class annoyedcoworkers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");

        int h = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);

        Comparator<Coworker> sortPQ = new Comparator<Coworker>() {
            public int compare(Coworker x, Coworker y) {
                return (x.annoyance + x.rate) - (y.annoyance + y.rate);
            }
        };

        PriorityQueue<Coworker> pq = new PriorityQueue<>(sortPQ);
        for (int i = 0; i < c; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            pq.add(new Coworker(a, b));
        }
        for (int i = 0; i < h; i++) {
            Coworker curr = pq.poll();
            curr.annoyance += curr.rate;
            pq.add(curr);
        }
        int maxAnnoyance = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            maxAnnoyance = Math.max(maxAnnoyance, pq.poll().annoyance);
        }
        pw.println(maxAnnoyance);
        pw.flush();
    }
}
