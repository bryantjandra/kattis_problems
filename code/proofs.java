
import java.util.*;
import java.io.*;

class proofs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        boolean isValid = true;
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split("->");
            if (tokens[0].length() > 0) {
                StringTokenizer st = new StringTokenizer(tokens[0].trim());
                while (st.hasMoreTokens()) {
                    if (!set.contains(st.nextToken())) {
                        isValid = false;
                        pw.println(i + 1);
                        break;
                    }
                }
            }
            if (!isValid) {
                break;
            }
            set.add(tokens[1].trim());
        }
        if (isValid) {
            pw.println("correct");
        }
        pw.flush();
        pw.close();
    }
}