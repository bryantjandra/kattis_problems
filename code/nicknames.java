import java.util.*;
import java.io.*;

class nicknames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int A = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < A; i++) {
            String name = br.readLine();
            for (int j = 1; j <= name.length(); j++) {
                String prefix = name.substring(0, j);
                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }
        }
        int B = Integer.parseInt(br.readLine());
        for (int i = 0; i < B; i++) {
            String nickname = br.readLine();
            pw.println(map.getOrDefault(nickname, 0));
        }
        pw.flush();
        pw.close();
    }
}
