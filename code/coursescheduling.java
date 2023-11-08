
import java.util.*;
import java.io.*;

class coursescheduling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, HashSet<String>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            String fullName = tokens[0] + tokens[1];
            String course = tokens[2];
            HashSet current = map.getOrDefault(course, new HashSet<>());
            current.add(fullName);
            map.put(course, current);
        }
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            pw.println(entry.getKey() + " " + entry.getValue().size());
        }
        pw.flush();
    }
}
