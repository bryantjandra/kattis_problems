
import java.util.*;
import java.io.*;

class gearchanging {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        int P = Integer.parseInt(tokens[2]);

        ArrayList<Integer> crank = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crank.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> backwheel = new ArrayList<>();
        StringTokenizer sa = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            backwheel.add(Integer.parseInt(sa.nextToken()));
        }

        ArrayList<Double> ratios = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ratios.add((double) crank.get(i) / backwheel.get(j));
            }
        }

        boolean isValid = true;
        Collections.sort(ratios);
        for (int i = 0; i < ratios.size() - 1; i++) {
            if ((ratios.get(i + 1) - ratios.get(i)) / ratios.get(i) > P / 100.0) {
                isValid = false;
            }
        }

        pw.println(isValid ? "Ride on!" : "Time to change gears!");
        pw.close();
    }
}
