import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

class IntegerPair implements Comparable<IntegerPair> {
    Integer _first, _second;

    public IntegerPair(Integer f, Integer s) {
        _first = f;
        _second = s;
    }

    public int compareTo(IntegerPair o) {
        if (!this.first().equals(o.first()))
            return this.first() - o.first();
        else
            return this.second() - o.second();
    }

    Integer first() {
        return _first;
    }

    Integer second() {
        return _second;
    }
}

class shortestpath1 {
    private static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        while (true) {
            String[] token = br.readLine().split(" ");
            int n = Integer.parseInt(token[0]), m = Integer.parseInt(token[1]);
            int q = Integer.parseInt(token[2]), s = Integer.parseInt(token[3]);
            if (n == 0 && m == 0 && q == 0 && s == 0) {
                break;
            }
            ArrayList<ArrayList<IntegerPair>> AL = new ArrayList<ArrayList<IntegerPair>>();
            for (int i = 0; i < n; i++) {
                AL.add(new ArrayList<>());
            }
            while (m-- > 0) {
                token = br.readLine().split(" ");
                int u = Integer.parseInt(token[0]), v = Integer.parseInt(token[1]), w = Integer.parseInt(token[2]);
                AL.get(u).add(new IntegerPair(v, w));
            }
            ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(n, INF));
            dist.set(s, 0);

            Comparator<IntegerPair> sortPQ = new Comparator<IntegerPair>() {
                @Override
                public int compare(IntegerPair x, IntegerPair y) {
                    return x.first() - y.first();
                }
            };

            PriorityQueue<IntegerPair> pq = new PriorityQueue<>(sortPQ);
            pq.add(new IntegerPair(0, s));
            while (!pq.isEmpty()) {
                IntegerPair front = pq.poll();
                int d = front.first();
                int u = front.second();
                if (d > dist.get(u)) { // ensures that if vertex with larger distance is pulled
                    // from the pq, it gets ignored. this has to be done as we are not updating
                    // distances within the pq (lazy deletion).
                    continue;
                }
                for (IntegerPair v_w : AL.get(u)) {
                    int v = v_w.first(), w = v_w.second();
                    if (dist.get(u) + w < dist.get(v)) {
                        dist.set(v, dist.get(u) + w);
                        pq.offer(new IntegerPair(dist.get(v), v));
                    }
                }
            }
            while (q-- > 0) {
                int t = Integer.parseInt(br.readLine());
                if (dist.get(t) == INF) {
                    pw.println("Impossible");

                } else {
                    pw.println(dist.get(t));
                }
            }
            pw.println();
        }
        pw.close();
    }
}
