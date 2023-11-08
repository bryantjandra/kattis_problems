import java.util.*;
import java.io.*;

class basicprogramming2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true); // true to auto-flush

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int t = Integer.parseInt(tokens[1]);
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (t == 1) {
            Set<Integer> set = new HashSet<>();
            boolean found = false;
            for (int i = 0; i < N; i++) {
                int diff = 7777 - nums[i];
                if (set.contains(diff)) {
                    pw.println("Yes");
                    found = true;
                    break;
                }
                set.add(nums[i]);
            }
            if (!found)
                pw.println("No");
        }

        else if (t == 2) {
            Set<Integer> set = new HashSet<>();
            boolean isUnique = true;
            for (int i = 0; i < N; i++) {
                if (set.contains(nums[i])) {
                    pw.println("Contains duplicate");
                    isUnique = false;
                    break;
                }
                set.add(nums[i]);
            }
            if (isUnique)
                pw.println("Unique");
        }

        else if (t == 3) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                if (countMap.get(num) > N / 2) {
                    pw.println(num);
                    return;
                }
            }
            pw.println("-1");
        }

        else if (t == 4) {
            Arrays.sort(nums);
            if (N % 2 == 1) {
                pw.println(nums[N / 2]);
            } else {
                pw.println(nums[N / 2 - 1] + " " + nums[N / 2]);
            }
        }

        else if (t == 5) {
            List<Integer> result = new ArrayList<>();
            for (int num : nums) {
                if (num >= 100 && num <= 999) {
                    result.add(num);
                }
            }
            Collections.sort(result);
            for (int i = 0; i < result.size(); i++) {
                pw.print(result.get(i));
                if (i != result.size() - 1)
                    pw.print(" ");
            }
            pw.println();
        }
    }
}
