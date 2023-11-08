import java.util.*;
import java.io.*;

class thanos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long T = Long.parseLong(br.readLine());

        while (T-- > 0) {
            String[] tokens = br.readLine().split(" ");
            long numYears = 0;
            long p = Long.parseLong(tokens[0]);
            long r = Long.parseLong(tokens[1]);
            long f = Long.parseLong(tokens[2]);
            while (p <= f) {
                numYears += 1;
                p = p * r;
            }
            pw.println(numYears);
        }
    }
}
