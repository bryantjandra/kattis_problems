import java.util.*;
import java.io.*;

class height {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int[] nums = new int[20];
            for (int i = 0; i < 20; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int counter = 0;
            for (int i = 1; i < 20; i++) {
                int key = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] > key) {
                    nums[j + 1] = nums[j];
                    j = j - 1;
                    counter++;
                }
                nums[j + 1] = key;
            }
            pw.println(p + " " + counter);
            pw.flush();
        }
    }
}