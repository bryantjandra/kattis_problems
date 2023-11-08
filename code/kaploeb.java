
import java.util.*;
import java.io.*;

class kaploeb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] tokens = br.readLine().split(" ");
        int l = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        int s = Integer.parseInt(tokens[2]);

        HashMap<Integer, Integer> runnersTime = new HashMap<>();
        HashMap<Integer, Integer> runnersLaps = new HashMap<>();
        for (int i = 0; i < l; i++) {
            tokens = br.readLine().split(" ");
            int startnum = Integer.parseInt(tokens[0]);
            String[] time = tokens[1].split("\\.");
            int minutes = Integer.parseInt(time[0]);
            int seconds = Integer.parseInt(time[1]);
            int totalSeconds = (minutes * 60) + seconds;
            runnersTime.put(startnum, runnersTime.getOrDefault(startnum, 0) + totalSeconds);
            runnersLaps.put(startnum, runnersLaps.getOrDefault(startnum, 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> timeCompare = new Comparator<>() {
            public int compare(Map.Entry<Integer, Integer> x, Map.Entry<Integer, Integer> y) {
                int timeDiff = x.getValue() - y.getValue();
                if (timeDiff != 0) {
                    return timeDiff;
                }
                return x.getKey() - y.getKey();
            }
        };

        ArrayList<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> x : runnersTime.entrySet()) { // entrySet() gets the key-value pairs in the //
            if (runnersLaps.get(x.getKey()) == k) {
                sortedList.add(x);
            }
        }

        Collections.sort(sortedList, timeCompare);
        for (Map.Entry<Integer, Integer> x : sortedList) {
            pw.println(x.getKey());
        }
        pw.close();
    }
}
