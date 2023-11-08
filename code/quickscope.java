
import java.util.*;
import java.io.*;

class quickscope {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        Stack<HashMap<String, String>> stack = new Stack<>();
        stack.push(new HashMap<>()); // global scope
        // NOTE: current scope will be innermost scope.

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            String command = tokens[0];
            if (command.equals("TYPEOF")) {
                String name = tokens[1];
                String type = findType(stack, name);
                pw.println(type);

            } else if (command.equals("DECLARE")) {
                String name = tokens[1];
                String type = tokens[2];
                if (stack.peek().containsKey(name)) {
                    pw.println("MULTIPLE DECLARATION");
                    pw.flush();
                    break;
                }
                stack.peek().put(name, type);
            } else if (command.equals("{")) {
                stack.push(new HashMap<>());
            } else if (command.equals("}")) {
                stack.pop();
            }
        }
    }

    public static String findType(Stack<HashMap<String, String>> stack, String name) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            if (stack.get(i).containsKey(name)) {
                return stack.get(i).get(name);
            }
        }
        return "UNDECLARED";
    }
}