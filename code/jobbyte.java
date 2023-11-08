import java.util.Scanner;

public class jobbyte {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read number of people (or jobs)

        int[] jobpeeps = new int[n];
        for (int i = 0; i < n; i++) {
            jobpeeps[i] = sc.nextInt() - 1; // Convert to 0-based index and store the jobs sequence
        }
        sc.close();

        System.out.println(numSteps(jobpeeps, n)); // Calculate and print the number of required job switches
    }

    public static int numSteps(int[] arr, int n) {
        boolean[] visited = new boolean[n]; // Array to keep track of visited people
        int totalsteps = 0; // Counter for the number of required job switches

        // Iterate through each person
        for (int i = 0; i < n; i++) {
            if (visited[i]) // If the person is already visited, we move to the next one
                continue;

            int curr = i; // Start with the current person
            visited[curr] = true; // Mark current person as visited

            // Follow the sequence until a visited person is found (completing a cycle)
            while (!visited[arr[curr]]) {
                totalsteps += 1; // Increment the switch counter as we're moving through the cycle
                curr = arr[curr]; // Move to the person who currently has the job of the current person
                visited[curr] = true; // Mark this person as visited
            }
        }

        return totalsteps; // Return the total number of required job switches
    }
}
