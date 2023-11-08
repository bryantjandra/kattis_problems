import java.util.*;
import java.io.*;

class cutinline {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            names.add(br.readLine());
        }
        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            String[] tokens = br.readLine().split(" ");
            String command = tokens[0];
            if (command.equals("cut")) {
                String name1 = tokens[1];
                String name2 = tokens[2];
                int idx = names.indexOf(name2);
                names.add(idx, name1);
            } else if (command.equals("leave")) {
                String name1 = tokens[1];
                names.remove(name1);
            }
        }
        for (String name : names) {
            System.out.println(name);
        }

    }
}
