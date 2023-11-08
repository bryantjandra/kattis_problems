import java.util.*;

public class rankproblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTeam = sc.nextInt(), matches = sc.nextInt();
        sc.nextLine();

        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 1; i <= numTeam; ++i)
            A.add(i); // insert 1,2,.... n

        while (matches-- > 0) {
            String line = sc.nextLine();
            String[] token = line.split(" ");

            int i = Integer.parseInt(token[0].substring(1));
            int j = Integer.parseInt(token[1].substring(1));

            int n = A.indexOf(i);
            int m = A.indexOf(j);

            if (n > m) {
                A.remove(m);
                A.add(n, j);
            }

        }

        for (var Ai : A)
            System.out.print("T" + Ai + " ");
        System.out.println();
    }

}