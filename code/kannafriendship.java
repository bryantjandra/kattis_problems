import java.util.*;
import java.io.*;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getLength() {
        return this.end - this.start + 1;
    }

    public boolean isOverlap(Interval other) {
        return Math.max(this.start, other.start) <= Math.min(this.end, other.end);
    }

    public void mergeTracks(Interval other) {
        this.start = Math.min(this.start, other.start);
        this.end = Math.max(this.end, other.end);
    }
}

class kannafriendship {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int Q = Integer.parseInt(tokens[1]);
        long res = 0;

        TreeMap<Integer, Interval> map = new TreeMap<>();

        for (int i = 0; i < Q; i++) {
            tokens = br.readLine().split(" ");
            int command = Integer.parseInt(tokens[0]);
            if (command == 1) {
                int s = Integer.parseInt(tokens[1]);
                int e = Integer.parseInt(tokens[2]);
                Interval interval = new Interval(s, e);

                while (true) {
                    Map.Entry<Integer, Interval> successor = map.ceilingEntry(s);
                    if (successor == null || !interval.isOverlap(successor.getValue())) {
                        break;
                    }
                    res -= successor.getValue().getLength();
                    interval.mergeTracks(successor.getValue());
                    map.remove(successor.getKey());
                }
                while (true) {
                    Map.Entry<Integer, Interval> predecessor = map.floorEntry(s);
                    if (predecessor == null || !interval.isOverlap(predecessor.getValue())) {
                        break;
                    }
                    res -= predecessor.getValue().getLength();
                    // result will be decremented everytime we remove a key-value pair
                    interval.mergeTracks(predecessor.getValue());
                    map.remove(predecessor.getKey());
                }
                map.put(interval.start, interval);

                res += interval.getLength();
                // result will be incremented everytie we add a key-value pair.
            } else if (command == 2) {
                pw.println(res);
            }
        }
        pw.flush();
        pw.close();
    }

}

// code to solve just subtask1 below:

class kannafriendship2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int q = Integer.parseInt(tokens[1]);
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < q; i++) {
            tokens = br.readLine().split(" ");
            int command = Integer.parseInt(tokens[0]);
            if (command == 1) {
                int start = Integer.parseInt(tokens[1]);
                int end = Integer.parseInt(tokens[2]);
                for (int j = start; j <= end; j++) {
                    visited[j] = true;
                }
            } else {
                int count = 0;
                for (int j = 1; j <= n; j++) {
                    if (visited[j]) {
                        count++;
                    }
                }
                pw.println(count);
            }
        }
        pw.flush();
    }
}
