import java.io.*;
import java.util.*;

class Jalanan implements Comparable<Jalanan> {
    int desa, shamans, titans;
    long distance;

    public Jalanan(int desa, long distance, int shamans, int titans) {
        this.desa = desa;
        this.distance = distance;
        this.shamans = shamans;
        this.titans = titans;
    }

    @Override
    public int compareTo(Jalanan other) {
        if (this.titans != other.titans)
            return this.titans - other.titans;
        else if (this.shamans != other.shamans)
            return this.shamans - other.shamans;
        else
            return Long.compare(this.distance, other.distance);
    }
}

public class fendofftitan {

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
        long[] minimizeTitans = new long[n];
        Arrays.fill(minimizeTitans, Long.MAX_VALUE);
        minimizeTitans[x] = 0;
        long[][] minimizeShamans = new long[n][m + 1000];
        long[][] dist = new long[n][m + 1000];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minimizeShamans[i], Long.MAX_VALUE);
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        minimizeShamans[x][0] = 0;
        dist[x][0] = 0;

        PriorityQueue<Jalanan> pq = new PriorityQueue<>();
        pq.add(new Jalanan(x, 0, 0, 0));
        while (!pq.isEmpty()) {
            Jalanan jalan = pq.poll();
            if (jalan.desa == y) {
                pw.println(jalan.distance + " " + jalan.shamans + " " + jalan.titans);
                pw.close();
                return;
            }
            for (int[] next : AL[jalan.desa]) {
                int nextVillage = next[0];
                long futureDist = jalan.distance + next[1];
                int futureShamans = jalan.shamans + (next[2] == 1 ? 1 : 0);
                int futureTitans = jalan.titans + (next[2] == 2 ? 1 : 0);
                if (futureTitans > minimizeTitans[nextVillage]) {
                    continue;
                }
                if (futureShamans < minimizeShamans[nextVillage][futureTitans]
                        || (futureShamans == minimizeShamans[nextVillage][futureTitans]
                                && futureDist < dist[nextVillage][futureTitans])) {
                    minimizeShamans[nextVillage][futureTitans] = futureShamans;
                    dist[nextVillage][futureTitans] = futureDist;
                    minimizeTitans[nextVillage] = futureTitans;
                    pq.add(new Jalanan(nextVillage, futureDist, futureShamans, futureTitans));
                }
            }
        }
        pw.println("IMPOSSIBLE");
        pw.close();
    }
}
