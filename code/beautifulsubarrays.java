
//turn on screen recording, this is a close internet PE
import java.util.*;
import java.io.*;

class beautifulsubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);
        int B = Integer.parseInt(tokens[2]);
        ArrayList<Integer> arr = new ArrayList<>();

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        while (st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int size = arr.size();
        // for (int i = 0; i < N; i++) {
        // for (int j = i + 1; j < N; j++) {
        // for (int x = j + 1; x < N; x++) {
        // if (arr.get(i) + arr.get(j) + arr.get(x) - size == B) {
        // pw.print(i);
        // pw.print(x);
        // pw.flush();
        // }
        // }
        // if (arr.get(i) + arr.get(j) - size == B) {
        // pw.print(i);
        // pw.print(j);
        // pw.flush();
        // }
        // }
        // }
        for (int i = 0; i < N; i++) {
            for(int j=1; j<)
        }
        pw.flush();

    }

}
