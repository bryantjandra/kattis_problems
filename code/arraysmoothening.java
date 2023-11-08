
import java.util.*;
import java.io.*;

class arraysmoothening {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        HashMap<Integer, Integer> map = new HashMap<>();

        while (st.hasMoreTokens()) {
            int curr = Integer.parseInt(st.nextToken());
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        Comparator<Integer> sortPQ = new Comparator<>() {
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(sortPQ);
        pq.addAll(map.values());
        for (int i = 0; i < K; i++) {
            int top = pq.peek();
            pq.poll();
            pq.offer(top - 1);
        }
        pw.println(pq.peek());

    }
}
