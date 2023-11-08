
import java.util.*;
import java.io.*;

class bungeebuilder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxJump = 0;
        int minHeight = arr[0];
        int maxHeight = arr[0];
        for (int i = 1; i < n; i++) {
            minHeight = Math.min(minHeight, arr[i]);
            if (arr[i] > maxHeight) {
                maxJump = Math.max(maxJump, maxHeight - minHeight);
                minHeight = maxHeight = arr[i];
            } else {
                maxJump = Math.max(maxJump, arr[i] - minHeight);
            }
        }
        pw.println(maxJump);
        pw.flush();
    }
}
