
import java.util.*;
import java.io.*;

class modulosolitaire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        long m = Long.parseLong(tokens[0]);
        long n = Long.parseLong(tokens[1]);
        long s0 = Long.parseLong(tokens[2]);

        ArrayList<Long> a = new ArrayList<>();
        ArrayList<Long> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            a.add(Long.parseLong(tokens[0]));
            b.add(Long.parseLong(tokens[1]));
        }

        Queue<Long> q = new LinkedList<>();
        q.offer(s0); // source vertex

        long INF = 1000000000;

        ArrayList<Long> dist = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            dist.add(INF);
        }
        dist.set((int) s0, 0L);

        while (!q.isEmpty()) { // bfs routine
            long u = q.poll(); // front of the queue
            for (int i = 0; i < n; i++) {
                long v = (long) (u * a.get(i) + b.get(i)) % m;
                if (!dist.get((int) v).equals(INF)) {
                    continue;
                }
                dist.set((int) v, dist.get((int) u) + 1);
                q.offer(v);
            }
        }
        if (!dist.get(0).equals(INF)) {
            pw.println(dist.get(0));
        } else {
            pw.println(-1);
        }
        pw.flush();
    }
}