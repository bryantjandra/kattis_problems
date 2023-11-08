
import java.util.*;
import java.io.*;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class speedrun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] tokens = br.readLine().split(" ");
        int G = Integer.parseInt(tokens[0]);
        int N = Integer.parseInt(tokens[1]);
        ArrayList<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            intervals.add(new Interval(a, b));
        }
        Comparator<Interval> sortIntervals = new Comparator<Interval>() {
            public int compare(Interval x, Interval y) {
                return x.end - y.end;
            }
        };
        Collections.sort(intervals, sortIntervals);
        int count = 0;
        int bufferEnd = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (interval.start >= bufferEnd) {
                count += 1;
                bufferEnd = interval.end;
            }
        }
        pw.println(count == G ? "YES" : "NO");
        pw.close();
    }
}
